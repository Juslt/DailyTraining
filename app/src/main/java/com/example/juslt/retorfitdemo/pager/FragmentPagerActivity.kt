package com.example.juslt.retorfitdemo.pager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.View
import com.example.juslt.retorfitdemo.R
import kotlinx.android.synthetic.main.activity_fragment_pager.*

class FragmentPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_pager)

        val fragment1 = Fragment1()
        val fragment2 = Fragment2()
        val fragment3 = Fragment3()
        val fragments = arrayListOf<Fragment>(fragment1,fragment2,fragment3)


        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.setupWithViewPager(view_pager)

        tabLayout.getTabAt(0)!!.text = "1"

        tabLayout.getTabAt(0)!!.text = "2"

        tabLayout.getTabAt(0)!!.text = "3"

        val adapter = object :FragmentPagerAdapter(supportFragmentManager){
            override fun getItem(p0: Int): Fragment {
               return fragments[p0]
            }

            override fun getCount(): Int {
               return fragments.size
            }

        }
        view_pager.adapter = adapter
    }
}
