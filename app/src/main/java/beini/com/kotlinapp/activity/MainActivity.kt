package beini.com.kotlinapp.activity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import beini.com.kotlinapp.R


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //返回类型 Int
    fun sum1(p: Int, q: Int): Int {
        return p + q
    }

    //表达式作为返回值
    fun sum2(p: Int, q: Int) = p + q

    //函数返回无意义的值，相当于 Java 里的 void
    fun sum3(p: Int, q: Int): Unit {
    }

    //Unit 返回类型可以省略：
    fun sum4(p: Int, q: Int) {

    }

    fun base2() {
        val a = 4
        val b = 6
        val c = if (a > b) a else b//可作为表达式
        Log.d("com.beini", "c==" + c)

        val name = "bb"
        when (name) {
            "a" -> Log.d("com.beini", "n1")
            "b" -> Log.d("com.beini", "n2")
            "beini" -> Log.d("com.beini", "n3")
            else -> {
                Log.d("com.beini", " else")
            }
        }
        val arry = arrayOf(1, 2, 3, 4, 5)
        for (arr in arry) {
            Log.d("com.beini", "arr==" + arr)
        }

    }

    fun base1() {
        val partIDobule: Double = 5.2
        val partInt: Int = partIDobule.toInt()
        val partChar: Char = 'a'
        val partBoolean: Boolean = true

        val name1 = "beini"
        val intruce: String = "my name $name1"
        Log.d("com.beini", intruce)
        val name2 = "beini"
        val stringLength = " name's  length is  ${name2.length}"
        Log.d("com.beini", stringLength)
        //装箱操作
        val arry1 = arrayOf(1, 2, 3)
        //原生类型数组
        val arr2: IntArray = intArrayOf(1, 2, 3)
        //指定数据长度
        val arr3 = arrayOfNulls<Int>(4)
        //长度为 0 的空数组
        val empty = emptyArray<Int>()
        //访问数组元素
        val arr4 = arrayOf(1, 2, 3)
        println(arr4[1])
        //修改元素
        arr4[1] = 10
        println(arr4[1])        //输出“10”
        //遍历数组
        for (arr in arr4) {
            println(arr)
        }
        //遍历数组下标
        for (arr in arr4.indices) {
            println(arr)
        }
    }

}
