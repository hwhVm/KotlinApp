package beini.com.kotlinapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import beini.com.kotlinapp.R
import beini.com.kotlinapp.constants.NetConstants
import beini.com.kotlinapp.net.RxNetUtil
import beini.com.kotlinapp.net.RxSchedulers
import beini.com.kotlinapp.net.request.LoginRequest
import beini.com.kotlinapp.net.response.BaseResponseJson
import beini.com.kotlinapp.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


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
        val account = et_account.text.toString().trim()
        val password = et_password.text.toString().trim()

        if (TextUtils.isEmpty(account)) {
            ToastUtil.showToast("account error")
            return
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtil.showToast("passowrd error")
            return
        }
        val request = LoginRequest(account, password, NetConstants.COMMAND_LOGIN)
        RxNetUtil.rxLoginBack(request)
                .compose(RxSchedulers.composeFloable())
                .subscribe(object : Subscriber<BaseResponseJson> {
                    override fun onSubscribe(s: Subscription) {
                        s.request(java.lang.Long.MAX_VALUE)
                    }

                    override fun onNext(baseResponseJson: BaseResponseJson?) {
                        if (baseResponseJson != null && baseResponseJson.ReturnCode == 0) {
                            val homeIntent: Intent = Intent()
                            homeIntent.setClass(this@LoginActivity, HomeActivity::class.java)
                            startActivity(homeIntent)
                        } else {
                            ToastUtil.showToast("login fail")
                        }
                    }

                    override fun onError(t: Throwable) {

                    }

                    override fun onComplete() {

                    }

                })


    }


}


