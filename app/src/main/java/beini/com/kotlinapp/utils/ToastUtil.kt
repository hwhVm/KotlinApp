package beini.com.kotlinapp.utils

import android.widget.Toast
import beini.com.kotlinapp.KotlinApplication

/**
 * Created by beini on 2017/6/5.
 */
object ToastUtil {

    fun showToast(str: String) {
        Toast.makeText(KotlinApplication.instance, str, Toast.LENGTH_SHORT).show()
    }
}