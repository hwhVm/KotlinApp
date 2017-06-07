package beini.com.kotlinapp.net

import beini.com.kotlinapp.net.response.BaseResponseJson
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path


/**
 * Created by beini on 2017/6/6.
 */
interface RxServer {
    @POST("{url}")
    fun sendRequest(@Path("url") url: String, @Body requestJson: Any): Call<BaseResponseJson>

    //标准rxjava2+retrofit2
    @POST("{url}")
    fun rxSendRequest(@Path("url") url: String, @Body requestJson: Any): Observable<BaseResponseJson>
    //背压
    @POST("{url}")
    fun rxSendRequestBack(@Path("url") url: String, @Body requestJson: Any): Flowable<BaseResponseJson>
}