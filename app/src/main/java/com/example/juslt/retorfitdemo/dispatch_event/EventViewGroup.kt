package com.example.juslt.retorfitdemo.dispatch_event

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

/**
 * Created by Juslt on 2019/8/6
 */
class EventViewGroup @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, def: Int = 0) : FrameLayout(context,attributeSet,def) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.e("===","viewGroup_dispatchTouchEvent-->${ev!!.action}")
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.e("===","viewGroup_onInterceptTouchEvent-->${ev!!.action}")
//        if(ev.action == MotionEvent.ACTION_MOVE){
//            return true
//        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e("===","viewGroup_onTouchEvent-->${event!!.action}")
         return super.onTouchEvent(event)
    }

}