package beini.com.kotlinapp.`interface`

import beini.com.kotlinapp.bean.WeatherinfoModel
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable
/**
 * Created by beini on 2017/6/5.
 */
interface ApiStores {
    companion object {
        //baseUrl
        val API_SERVER_URL = "http://www.weather.com.cn/"
    }
    //加载天气
    @GET("adat/sk/{cityId}.html")
    fun loadData(@Path("cityId") cityId: String): Observable<WeatherinfoModel>
}