package com.example.juslt.retorfitdemo.sliding_conflict

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import com.example.juslt.retorfitdemo.R
import kotlinx.android.synthetic.main.activity_sliding_confilct.*

class SlidingConflictActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliding_confilct)


        for(i in 0..3){

            val content = layoutInflater.inflate(R.layout.list_content,scroll_view_ext,false) as ViewGroup
            val textView = content.findViewById<TextView>(R.id.list_name)
            textView.text = "listView$i"

            content.setBackgroundColor(Color.rgb(255/(i+1),255/(i+1),0))

            createListView(content)

            scroll_view_ext.addView(content)
        }

    }

    fun createListView(content: View) {
        val listView = content.findViewById<ListView>(R.id.list_view)
        val datas = ArrayList<String>()
        for (i in 0..50) {
            datas.add("name$i")
        }

        val adapter = ArrayAdapter<String>(this,R.layout.item_list,R.id.tv_name,datas)
        listView.adapter = adapter
    }


}
