package beini.com.kotlinapp.bean

import android.util.Log

/**
 * Created by beini on 2017/6/3.
 */
class A (val a: Int) : Base{
    override fun print() {
        Log.d("wxl", "a=" + a)
    }
}