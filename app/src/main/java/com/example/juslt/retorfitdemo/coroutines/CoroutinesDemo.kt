package com.example.juslt.retorfitdemo.coroutines

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

/**
 * Created by Juslt on 2019/8/13
 */
object CoroutinesDemo {
    val c = AtomicLong()
    @JvmStatic
    fun main(args: Array<String>) {
        println("start")
       val deferred =  (1..1000000).map { n ->
            GlobalScope.async {
                delay(1000)
                n
            }
        }
//        val sum = deferred.sumBy { it.await() }

        runBlocking {
            val sum = deferred.sumBy { it.await() }
            println("Sum:$sum")
        }
        runBlocking {
            workLoad()
        }

//        for(i in 1..1000000L){
//            GlobalScope.launch {
//                c.addAndGet(i)
//            }
//        }
//        println(c.get())


//        for(i in 1..1000000L){
//            thread {
//                c.addAndGet(i)
//            }
//        }
//        println(c.get())

//        GlobalScope.launch {
//            delay(1000)
//            println("hello")
//        }
//        runBlocking {
//            delay(1000)
//        }
//        Thread.sleep(2000)
//        println("stop")
    }

    suspend fun workLoad(){
        delay(1000)
        println("workload")
    }
}
