package com.example.juslt.retorfitdemo.dispatch_event

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.TextView

/**
 * Created by Juslt on 2019/8/6
 */
class EventView @JvmOverloads constructor(context:Context,attributeSet: AttributeSet?=null,defInt:Int=0):Button(context,attributeSet,defInt){

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.e("===","view_dispatchTouchEvent-->${event!!.action}")
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e("===","view_onTouchEvent-->${event!!.action}")
        return true
    }
}