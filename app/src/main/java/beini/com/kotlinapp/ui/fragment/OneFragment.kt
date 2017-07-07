package beini.com.kotlinapp.ui.fragment


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import beini.com.kotlinapp.R


/**
 * Create by beini  2017/7/7
 */
class OneFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_one, container, false)
    }

}
