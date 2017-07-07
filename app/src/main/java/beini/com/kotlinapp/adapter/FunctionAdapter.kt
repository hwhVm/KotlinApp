package beini.com.kotlinapp.adapter

import android.graphics.Color
import android.support.v4.view.PagerAdapter
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by beini on 2017/6/8.
 */
class FunctionAdapter constructor(datas: List<String>) : PagerAdapter() {

    private val mDataList: List<String> = datas


    override fun getCount(): Int {
        return mDataList.size
    }

    override fun isViewFromObject(view: View?, objectAny: Any?): Boolean {
        return view == objectAny
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val textView = TextView(container!!.context)
        textView.text = mDataList[position]
        textView.gravity = Gravity.CENTER
        textView.setTextColor(Color.BLACK)
        textView.textSize = 24f
        container.addView(textView)
        return textView
    }

    override fun destroyItem(container: ViewGroup?, position: Int, objectAny: Any?) {
        container!!.removeView(objectAny as View?)
    }

    override fun getItemPosition(`object`: Any?): Int {
        val textView = `object` as TextView
        val text = textView.text.toString()
        val index = mDataList.indexOf(text)
        if (index >= 0) {
            return index
        }
        return PagerAdapter.POSITION_NONE
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mDataList[position]
    }
}