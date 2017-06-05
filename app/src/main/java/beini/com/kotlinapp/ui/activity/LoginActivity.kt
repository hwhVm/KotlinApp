package beini.com.kotlinapp.ui.activity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import beini.com.kotlinapp.ApiClient
import beini.com.kotlinapp.R
import beini.com.kotlinapp.bean.WeatherinfoModel
import beini.com.kotlinapp.callback.ApiCallback
import beini.com.kotlinapp.utils.BLog
import beini.com.kotlinapp.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_login -> login()
        }
    }

    fun login() {
        val account = et_account.text.trim()
        val passowrd = et_password.text.trim()

        if (TextUtils.isEmpty(account)) {
            ToastUtil.showToast("account error")
            return
        }
        if (TextUtils.isEmpty(passowrd)) {
            ToastUtil.showToast("passowrd error")
            return
        }
        BLog.d("account=$account   passowrd=$passowrd")

    }

    fun getWeatherData() {
        //object为对象表达式
        addSubscription(ApiClient.retrofit().loadData("101190201"), object : ApiCallback<WeatherinfoModel>() {
            override fun onSuccess(model: WeatherinfoModel) {
                BLog.d("city=" + model.city + ",cityid=" + model.cityid)//输出“city=无锡,cityid=101190201”
            }

            override fun onFailure(msg: String?) {
                BLog.d("onFailure=" + msg)
            }

            override fun onFinish() {
                BLog.d("onFinish")
            }
        })
    }
}
