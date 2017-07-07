package beini.com.kotlinapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import beini.com.kotlinapp.R
import beini.com.kotlinapp.bean.Article
import kotlinx.android.synthetic.main.article_item.view.*

/**
 * Created by beini on 2017/7/7.
 */
class OneAdapter constructor(val context: Context, val list: List<Article>) : RecyclerView.Adapter<OneAdapter.FanfouPostsViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var mListener: OnRecyclerViewOnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FanfouPostsViewHolder? {
        val view: View = inflater.inflate(R.layout.article_item, parent, false)
        return FanfouPostsViewHolder(view, mListener!!)
    }

    override fun onBindViewHolder(holder: FanfouPostsViewHolder, position: Int) {
        val item = list[position]
        holder.itemView.text_title.text = item.title
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FanfouPostsViewHolder(itemView: View, listener: OnRecyclerViewOnClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var listener: OnRecyclerViewOnClickListener = listener

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            listener.OnItemClick(p0!!, layoutPosition)
        }

    }

    interface OnRecyclerViewOnClickListener {

        fun OnItemClick(v: View, position: Int)

    }
}