package com.example.juslt.retorfitdemo.handler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.support.annotation.MainThread
import com.example.juslt.retorfitdemo.R

class HandlerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)



        val thread = Thread(Runnable {
            Looper.prepare()
            val handler = Handler(Looper.myLooper(), Handler.Callback {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            })
            val looper  = Looper.myLooper()
            Looper.loop()
        }).start()

        val mainHandler = Handler(Looper.getMainLooper())
        for(i in 0..10){
            val message = Message.obtain()
            message.what = 1
            mainHandler.sendMessage(message)
        }
    }
}
