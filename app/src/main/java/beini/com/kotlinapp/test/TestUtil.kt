package beini.com.kotlinapp.test

import org.junit.Before
import org.junit.Test
import java.io.File
import java.net.URL

/**
 * Created by beini on 2017/6/5.
 */
class TestUtil {
    @Before
    fun setUp() {
    }

    @Test
    fun getStringLength() {
        val systemDir = File("""C:\\Users\\Administrator\\Desktop\\loong""")
        val fileTree: FileTreeWalk = systemDir.walk()
        fileTree.maxDepth(Int.MAX_VALUE)
                .filter { it.isFile }
                .filter { it.extension == "java" }
                .forEach {
                    println(it.isDirectory)
                }
    }

    @Test
    fun netOption() {
        //返回百度首页
//        val baidu = URL("http://www.baidu.com")
//        val contents = baidu.readText()
//        println(contents)
        //获取必应首页图片并保存
        //获取XML格式图片信息
        val bing = URL("http://www.bing.com/HPImageArchive.aspx?format=xml&idx=0&n=1&mkt=en-US")
        val texts = bing.readText()
        //获取url地址和文件名
        val regex = Regex("""<url>(.*)</url>""")
        val result = regex.find(texts)
        val imageUrl = "http://www.bing.com" + result!!.groupValues[1]
        val filename = imageUrl.substring(imageUrl.lastIndexOf('/'))
        //写入文件
        println("写入文件的目录==" + System.getProperty("user.dir") + "\\out")
        val output = File(System.getProperty("user.dir") + "\\out", filename)
        val requestUrl = URL(imageUrl)
        output.writeBytes(requestUrl.readBytes())
    }

    @Test
    fun testFun() {
       println( returnSum(1, 2))
    }

    fun returnSum(a: Int, b: Int) = (a + b)

}