package beini.com.kotlinapp.ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.View
import beini.com.kotlinapp.utils.BLog

/**
 * Created by beini on 2017/7/8.
 */
open class BaseFrgment : Fragment() {
    private var isVisible: Boolean? = null
    private var isPrepared: Boolean = false
    private var isFirst = true


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        BLog.d("        isVisibleToUser=" + isVisibleToUser)
        if (userVisibleHint) {
            isVisible = true
            lazyLoad()
        } else {
            isVisible = false
            onInvisible()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        BLog.d("        onActivityCreated  ")
        isPrepared = true
        lazyLoad()
    }

   open fun lazyLoad() {
        BLog.d("  isPrepared  =$isPrepared   isVisible=$isVisible   isFirst=$isFirst")

        if (!isPrepared || !isVisible!! || !isFirst) {
            return
        }
        initDatas()
        isFirst = false
    }

    open fun onInvisible() {
        BLog.d("  onInvisible  ")
    }

    open  fun initDatas() {

    }

}