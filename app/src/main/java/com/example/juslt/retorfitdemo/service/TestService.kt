package com.example.juslt.retorfitdemo.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

/**
 * Created by Juslt on 2019/8/26
 */
class TestService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        Log.e("===","onBind")
        return MyBinder()
    }

    override fun onCreate() {
        Log.e("===","onCreate")
        super.onCreate()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("===","onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e("===","onUnbind")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.e("===","onDestroy")
        super.onDestroy()
    }

    fun printNum(){
        Log.e("===","printNum")
    }
    //client 可以通过Binder获取Service实例
    inner class MyBinder : Binder() {
        val service: TestService
            get() = this@TestService
    }

}