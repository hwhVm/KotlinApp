package beini.com.kotlinapp.net

import android.os.Environment
import beini.com.kotlinapp.constants.NetConstants
import beini.com.kotlinapp.net.request.LoginRequest
import beini.com.kotlinapp.net.response.BaseResponseJson
import beini.com.kotlinapp.utils.BLog
import com.google.gson.GsonBuilder
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit


/**
 * Created by beini on 2017/6/6.
 */
object RxNetUtil {
    private var retrofit: Retrofit? = null
    private var rxServer: RxServer? = null
    private val DEFAULT_TIMEOUT = 5

    init {
        val gson = GsonBuilder()
                .setLenient()
                .create()
        val client = OkHttpClient.Builder().connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .cache(Cache(File(Environment.getExternalStorageDirectory().toString() + "/tmp"), (10 * 1024 * 1024).toLong()))   //设置缓存目录和10M缓存
                .build()
        retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(NetConstants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                // 添加Retrofit到RxJava的转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        rxServer = retrofit!!.create(RxServer::class.java)
    }

    fun login(loginRequest: LoginRequest, subscriber: ResourceSubscriber<BaseResponseJson>, scheduler: Scheduler) {
        BLog.d(" ----------->login")
        Flowable.create<BaseResponseJson>({
            try {
                val baseResponseJsonResponse = rxServer!!.sendRequest(loginRequest.url, loginRequest).execute()
                if (baseResponseJsonResponse.body() == null) {
                    subscriber.onError(Throwable("error"))
                } else {
                    subscriber.onNext(baseResponseJsonResponse.body() as BaseResponseJson)
                    subscriber.onComplete()
                }
            } catch (e: IOException) {
                BLog.d("   ------>  " + e.localizedMessage)
                subscriber.onError(Throwable("error"))
                e.printStackTrace()
            }
        }, BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io()).observeOn(scheduler)
                .subscribe(subscriber)
    }

    /**
     * 标准rxjava2+retrofit2
     */
    fun rxLogin(loginRequest: LoginRequest): Observable<BaseResponseJson> {

        return rxServer!!.rxSendRequest(loginRequest.url, loginRequest)
    }

    fun rxLoginBack(loginRequest: LoginRequest): Flowable<BaseResponseJson> {

        return rxServer!!.rxSendRequestBack(loginRequest.url, loginRequest)
    }

}