package beini.com.kotlinapp.utils

import android.util.Log

/**
 * Created by beini on 2017/6/3.
 * 类名：BLog
 * 主构造函数：constructor(val temp:String)
 * 日志工具
 */
class BLog {
    companion object {
        val debug = true
        fun d(content: String, tag: String = "com.beini") {
            if (debug) {
                Log.d(tag, content)
            }
        }
    }

}