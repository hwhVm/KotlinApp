package beini.com.kotlinapp

import android.app.Application

/**
 * Created by beini on 2017/6/5.
 */
class KotlinApplication : Application() {
    init {
        instance = this
    }

    companion object {
        lateinit var instance: KotlinApplication
    }

    override fun onCreate() {
        super.onCreate()
    }

}