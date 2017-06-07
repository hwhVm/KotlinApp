package beini.com.kotlinapp.ui.activity

import android.app.Activity
import android.os.Bundle
import beini.com.kotlinapp.R

open class BaseActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
