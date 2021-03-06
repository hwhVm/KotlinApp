package beini.com.kotlinapp.bean

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**
 * Created by beini on 2017/7/7.
 */
class Article : Serializable {

    var id: Int? = null
    var title: String? = null
    var picUrl: String? = null
    var commentNum: Int? = null
    var author: String? = null
    var data: String? = null
    var content: String? = null

    constructor(id: Int, title: String, picUrl: String, author: String, commentNum: Int,
                data: String, content: String) {
        this.id = id
        this.title = title
        this.picUrl = picUrl
        this.author = author
        this.commentNum = commentNum
        this.data = data
        this.content = content
    }

}