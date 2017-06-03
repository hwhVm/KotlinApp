package beini.com.kotlinapp.bean

import beini.com.kotlinapp.utils.BLog

/**
 * Created by beini on 2017/6/3.
 */
open class Person {
    val name = "beini"

    open fun speack() {
        BLog.d("speack")
    }

    open fun walk() {
        BLog.d("walk")
    }

    inner class A {
        fun speack() {
            print(name)
        }
    }
}