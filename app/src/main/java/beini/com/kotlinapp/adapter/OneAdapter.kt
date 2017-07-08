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
class OneAdapter constructor(val context: Context, val list: List<Article>) : RecyclerView.Adapter<OneAdapter.ArticleViewHolder>(), View.OnClickListener {


    private val inflater: LayoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder? {
        val view: View = inflater.inflate(R.layout.article_item, parent, false)
        view.setOnClickListener(this)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = list[position]
        holder.itemView.tag = position
        holder.itemView.text_title.text = item.title
        //article_image1 article_image2 article_image3
        holder.itemView.text_author.text = item.author
        holder.itemView.text_comment.text = item.commentNum.toString()
        holder.itemView.text_date.text = item.data
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    //item  click 事件
    private var itemClickListener: OnItemClickListener? = null

    fun setItemClick(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onClick(view: View) {
        if (itemClickListener != null)
            itemClickListener!!.onItemClick(view, view.tag as Int)
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}