package beini.com.kotlinapp.net.response

/**
 * Created by beini on 2017/7/8.
 */
class ArticleResponse {
    var id: Int? = null
    var title: String? = null
    var picUrl: String? = null
    var commentNum: Int? = null
    var author: String? = null
    var data: String? = null

    constructor(id: Int, title: String, picUrl: String, author: String, commentNum: Int,
                data: String) {
        this.id = id
        this.title = title
        this.picUrl = picUrl
        this.author = author
        this.commentNum = commentNum
        this.data = data
    }
}