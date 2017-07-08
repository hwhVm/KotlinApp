package beini.com.kotlinapp.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import beini.com.kotlinapp.R
import beini.com.kotlinapp.bean.Article
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val intent = this.intent
        val article: Article = intent.getSerializableExtra("article") as Article
//        if (article != null) {
//            text_detail_title.text = article.title
//            text_detail_content.text = article.content
//        }
        web_view.settings.javaScriptEnabled = true////设置WebView属性，能够执行Javascript脚本
        web_view.setWebViewClient(object : WebViewClient() {
            //避免打开系统浏览器
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        })
        web_view.loadUrl(article.picUrl)

    }

//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && web_view.canGoBack()) {
//            web_view.goBack() //goBack()表示返回WebView的上一页面
//            return true
//        }
//        return false
//    }

}
