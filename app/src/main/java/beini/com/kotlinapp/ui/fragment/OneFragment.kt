package beini.com.kotlinapp.ui.fragment


import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import beini.com.kotlinapp.R
import beini.com.kotlinapp.adapter.OneAdapter
import beini.com.kotlinapp.bean.Article
import kotlinx.android.synthetic.main.fragment_one.view.*


/**
 * Create by beini  2017/7/7
 */
class OneFragment : Fragment() {
    private var datas = ArrayList<Article>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.fragment_one, container, false)
        initDatas()
        initView(view)
        return view
    }

    fun initDatas() {
        val article1 = Article(1, "愿有人陪你颠沛流离1", 20171)
        val article2 = Article(2, "愿有人陪你颠沛流离2", 20172)
        val article3 = Article(3, "愿有人陪你颠沛流离3", 20173)
        datas.add(article1)
        datas.add(article2)
        datas.add(article3)
    }

    fun initView(view: View) {
        val oneAdapter: OneAdapter = OneAdapter(activity, datas)
        val manager = LinearLayoutManager(activity)
        manager.orientation = LinearLayoutManager.VERTICAL
        view.recycle_view_data.layoutManager = manager
        view.recycle_view_data.adapter = oneAdapter
    }

}
