package beini.com.kotlinapp.net

import io.reactivex.FlowableTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by beini on 2017/6/7.
 */
object RxSchedulers {
    /**
     * IO线程进行请求，在主线程进行回调
     */
    fun <T> compose(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable
                    .subscribeOn(Schedulers.io())
//                    .doOnSubscribe {
//                        if (!Utils.isNetworkConnected()) {
//                            Toast.makeText(context, R.string.toast_network_error, Toast.LENGTH_SHORT).show();
//                        }
//                    }
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> composeFloable(): FlowableTransformer<T, T> {
        return FlowableTransformer {
            flowable ->
            flowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }

    }


}
