package com.example.juslt.retorfitdemo.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Juslt on 2019/9/5
 */
object CoruntinesTest {

    //    @JvmStatic
//    fun main(args: Array<String>) = runBlocking <Unit>{
//        GlobalScope.launch {
//            println("world!")
//            delay(1000)
//        }
//        println("hello ")
//        delay(2000)
//    }
    @JvmStatic
    fun main(args: Array<String>) = runBlocking <Unit>{

        val job = GlobalScope.launch {
            println("world!")
            delay(1000)
        }
        println("hello ")
        job.join()
    }
}