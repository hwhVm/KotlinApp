package beini.com.kotlinapp

import beini.com.kotlinapp.`interface`.ApiStores
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by beini on 2017/6/5.
 */
object ApiClient {
    fun retrofit(): ApiStores {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            // Log信息拦截器
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            //设置 Debug Log 模式
            builder.addInterceptor(loggingInterceptor)
        }
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
                .baseUrl(ApiStores.API_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        //ApiStores::class.java取得对象的 Java 类
        return retrofit.create(ApiStores::class.java)
    }
}