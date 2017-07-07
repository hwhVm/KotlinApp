package beini.com.kotlinapp.ui.activity

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import beini.com.kotlinapp.R
import beini.com.kotlinapp.adapter.ViewPagerAdapter
import beini.com.kotlinapp.ui.fragment.OneFragment
import beini.com.kotlinapp.ui.fragment.ThreeFragment
import beini.com.kotlinapp.ui.fragment.TwoFragment
import kotlinx.android.synthetic.main.activity_home.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView


class HomeActivity : Activity() {
    private var fragments = ArrayList<Fragment>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViewAndData()
    }

    fun initViewAndData() {
        val mDataList = listOf("Java", "Android", "Kotlin", "C++", "HTML")

        fragments.add(OneFragment())
        fragments.add(TwoFragment())
        fragments.add(ThreeFragment())


        val viewPagerAdapter = ViewPagerAdapter(fragments, fragmentManager)


        view_pager.adapter = viewPagerAdapter

        magic_indicator.setBackgroundColor(Color.parseColor("#d43d3d"))

        val commonNavigator = CommonNavigator(this)
        commonNavigator.isSkimOver = true
        commonNavigator.adapter = object : CommonNavigatorAdapter() {

            override fun getCount(): Int {
                return mDataList?.size
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val clipPagerTitleView = ClipPagerTitleView(context)
                clipPagerTitleView.text = mDataList[index]
                clipPagerTitleView.textColor = Color.parseColor("#f2c4c4")
                clipPagerTitleView.clipColor = Color.WHITE
                clipPagerTitleView.setOnClickListener { view_pager.currentItem = index }
                return clipPagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator? {
                return null
            }
        }

        magic_indicator.navigator = commonNavigator
        ViewPagerHelper.bind(magic_indicator, view_pager)
    }
}
