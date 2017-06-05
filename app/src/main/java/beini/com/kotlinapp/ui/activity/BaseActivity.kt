package beini.com.kotlinapp.ui.activity

import android.app.Activity
import android.os.Bundle
import beini.com.kotlinapp.R
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

open class BaseActivity : Activity() {
    val mCompositeSubscription: CompositeSubscription = CompositeSubscription()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    override fun onDestroy() {
        if (mCompositeSubscription.hasSubscriptions()) {
            //取消注册，以避免内存泄露
            mCompositeSubscription.unsubscribe()
        }
        super.onDestroy()
    }
    open fun <M> addSubscription(observable: Observable<M>, subscriber: Subscriber<M>) {
        mCompositeSubscription.add(
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subscriber))
    }
}
