package beini.com.kotlinapp.adapter

import android.app.Fragment
import android.app.FragmentManager


/**
 * Created by beini on 2017/7/7.
 */
class ViewPagerAdapter constructor(datas: List<android.app.Fragment>, fm: FragmentManager) : android.support.v13.app.FragmentPagerAdapter(fm) {

    private var fragments = ArrayList<android.app.Fragment>()

    init {
        fragments = datas as ArrayList<Fragment>
    }

    override fun getCount(): Int {
        return fragments.size
    }


    override fun getItem(p0: Int): Fragment {
        return fragments[p0]
    }


}


