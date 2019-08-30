package com.example.juslt.retorfitdemo.stick_layout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.juslt.retorfitdemo.R
import kotlinx.android.synthetic.main.activity_stick_layout.*

class StickLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stick_layout)


        val datas = ArrayList<String>()
        for (i in 0..50){
            datas.add("item$i")
        }

        val adapter = ArrayAdapter(this,R.layout.item_list,R.id.tv_name,datas)
        list_view.adapter = adapter

        val params = list_view.layoutParams
        params.height = resources.displayMetrics.heightPixels
    }
}
