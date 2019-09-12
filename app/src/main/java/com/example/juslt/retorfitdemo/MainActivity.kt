package com.example.juslt.retorfitdemo

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Looper
import android.os.SystemClock
import android.support.annotation.MainThread
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import com.example.juslt.retorfitdemo.activity.RxActivity
import com.example.juslt.retorfitdemo.adapter.Adapter
import com.example.juslt.retorfitdemo.pager.FragmentPagerActivity
import com.example.juslt.retorfitdemo.service.TestService
import com.example.juslt.retorfitdemo.sliding_conflict.SlidingConflictActivity
import com.example.juslt.retorfitdemo.stick_layout.StickLayoutActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_rx_java.setOnClickListener {
            SystemClock.sleep(200000)
            startActivity(Intent(this, RxActivity::class.java))
        }
        btn_request.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://gank.io/api/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val request = retrofit.create(RequestInterface::class.java)
            val call = request.gankAPI()
            call.enqueue(object : Callback<GankBean> {
                override fun onFailure(call: Call<GankBean>, t: Throwable) {
                }

                override fun onResponse(call: Call<GankBean>, response: Response<GankBean>) {
                    tv_response.text = response.body().toString()
                }

            })
        }

        btn_sliding_conflict.setOnClickListener {
            startActivity(Intent(this, SlidingConflictActivity::class.java))
        }
        btn_stick_layout.setOnClickListener {
            startActivity(Intent(this, StickLayoutActivity::class.java))
        }
        btn_fragment_lazy_load.setOnClickListener {
            startActivity(Intent(this,FragmentPagerActivity::class.java))
        }

//        val string = StringFormatUtil.transform(null)
        //简单工厂模式
//        StaticFactory.createProduct("A").show()
//        StaticFactory.createProduct("B").show()

        //工厂方法模式
//        FactoryA().createProduct().show()
//        FactoryB().createProduct().show()

        //抽象工厂模式
//        MultiFactoryA().createTypeA().show()
//        MultiFactoryA().createTypeB().show()
//
//        MultiFactoryB().createTypeA().show()
//        MultiFactoryB().createTypeB().show()

        //适配器模式
        val adapter = Adapter()
        adapter.request()


//        val inter = DynamicProxy(Vendor())
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true")
//        val sell = Proxy.newProxyInstance(Sell::class.java.classLoader, arrayOf(Sell::class.java),inter) as Sell
//
//        sell.sell()
//        sell.ad()
//        event_view_group.setOnTouchListener(object : View.OnTouchListener{
//            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//                return true
//            }
//
//        })
//        animation_view.setAnimation("navigation.json")
//        animation_view.repeatCount =0
//        animation_view.playAnimation()



        btn_bind_service.setOnClickListener {
            val intent = Intent(this,TestService::class.java)
            bindService(intent,conn, Context.BIND_AUTO_CREATE)
        }
    }

    val conn = object :ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            (service as TestService.MyBinder).service.printNum()
            Log.e("===","onServiceConnected")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.e("===","onServiceDisconnected")
        }

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.e("===", "activity_dispatchTouchEvent-->${ev!!.action}")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e("===", "activity_onTouchEvent-->${event!!.action}")
        return super.onTouchEvent(event)
    }
}
