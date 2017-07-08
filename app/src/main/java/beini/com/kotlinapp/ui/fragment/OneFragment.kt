package beini.com.kotlinapp.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import beini.com.kotlinapp.R
import beini.com.kotlinapp.adapter.OneAdapter
import beini.com.kotlinapp.bean.Article
import beini.com.kotlinapp.net.RxNetUtil
import beini.com.kotlinapp.net.RxSchedulers
import beini.com.kotlinapp.net.request.GetArticleRequest
import beini.com.kotlinapp.net.response.BaseResponseJson
import beini.com.kotlinapp.ui.activity.DetailsActivity
import beini.com.kotlinapp.ui.view.LineDecoration
import beini.com.kotlinapp.utils.BLog
import beini.com.kotlinapp.utils.ToastUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_one.view.*
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


/**
 * Create by beini  2017/7/7
 */
class OneFragment : BaseFrgment() {

    private var mRootView: View? = null
    private var lists = ArrayList<Article>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            val view: View = inflater!!.inflate(R.layout.fragment_one, container, false)
            mRootView = view
//            initView(view)
        }
        return mRootView
    }

    override fun initDatas() {
        super.initDatas()

        RxNetUtil.rxGetArticles(GetArticleRequest())
                .compose(RxSchedulers.composeFloable())
                .subscribe(object : Subscriber<BaseResponseJson> {
                    override fun onSubscribe(s: Subscription) {
                        s.request(java.lang.Long.MAX_VALUE)
                    }

                    override fun onNext(baseResponseJson: BaseResponseJson?) {
                        if (baseResponseJson != null && baseResponseJson.ReturnCode == 0) {
                            val str: String = baseResponseJson.ReturnMessage
                            val type = object : TypeToken<ArrayList<Article>>() {}.type
                            lists = Gson().fromJson(str, type)

                            val oneAdapter: OneAdapter = OneAdapter(activity, lists)
                            val manager = LinearLayoutManager(activity)
                            manager.orientation = LinearLayoutManager.VERTICAL
                            view.recycle_view_data.layoutManager = manager
                            view.recycle_view_data.addItemDecoration(LineDecoration(activity))
                            view.recycle_view_data.adapter = oneAdapter
                            oneAdapter.setItemClick(onItemClickListener)
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

    internal var onItemClickListener: OneAdapter.OnItemClickListener = object : OneAdapter.OnItemClickListener {

        override fun onItemClick(view: View, position: Int) {
            BLog.d("   onItemClickListener   position==" + position)
            val homeIntent: Intent = Intent()
            val bundle = Bundle()
            bundle.putSerializable("article", lists.get(position))
            homeIntent.putExtras(bundle)
            homeIntent.setClass(activity, DetailsActivity::class.java)
            startActivity(homeIntent)
        }
    }
}

