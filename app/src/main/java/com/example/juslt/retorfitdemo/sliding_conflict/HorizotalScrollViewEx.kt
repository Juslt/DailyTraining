package com.example.juslt.retorfitdemo.sliding_conflict

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Scroller

/**
 * Created by Juslt on 2019/8/7
 */
class HorizotalScrollViewEx @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null, def: Int = 0
) : ViewGroup(context, attributeSet, def) {

    private val mScroller by lazy { Scroller(context) }
    private val velocityTracker by lazy { VelocityTracker.obtain() }
    private var isVelocity = false

    init {
        setWillNotDraw(false)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height)
        measureChildren(
            MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
        )
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for (i in 0 until childCount) {
            val width = context.resources.displayMetrics.widthPixels
            val height = context.resources.displayMetrics.heightPixels
            getChildAt(i).layout(i * width, 0, width * (i + 1), height)
            Log.e("===", "child$i")
        }
    }

    var lastX = 0f
    var lastY = 0f
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        val x = ev!!.x
        val y = ev.y
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
                if(!mScroller.isFinished){
                    mScroller.abortAnimation()
                    return true
                }
                return false
            }
            MotionEvent.ACTION_MOVE -> {
                val detalX = x - lastX
                val detalY = y - lastY
                if (Math.abs(detalX) > Math.abs(detalY)) {
                    return true
                }
            }
        }
        return super.onInterceptTouchEvent(ev)
    }

    var velocityX = 0f

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                if(!mScroller.isFinished){
                    mScroller.abortAnimation()
                }
                lastX = event.x
                lastY = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                Log.e("===scrollX:", "$scrollX")
//                if (scrollX < 0) return true

                val detalX = event.x - lastX
                scrollBy(-detalX.toInt(), 0)

                lastX = event.x
                lastY = event.y


            }
            MotionEvent.ACTION_UP -> {
                velocityTracker.addMovement(event)
                velocityTracker.computeCurrentVelocity(1000)
                velocityX = velocityTracker.xVelocity
                val velocityY = velocityTracker.yVelocity
                isVelocity = Math.abs(velocityX) > 50

                val width = context.resources.displayMetrics.widthPixels
                var position = 0
                if (!isVelocity) {
                    position = (scrollX + width / 2) / width
                } else {
                    if (velocityX > 0) {
                        position = scrollX / width
                    } else {
                        position = (scrollX / width) + 1
                    }

                }

                if(position>=childCount){
                    position = childCount-1
                }
                val targetX = width * position
                Log.e("=== position:", "$position")
                Log.e("=== targetX:", "$targetX")
                mScroller.startScroll(scrollX, 0, targetX - scrollX, 0, 500)
                invalidate()
                velocityTracker.clear()
            }
        }
        return super.onTouchEvent(event)
    }

    override fun computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.currX, mScroller.currY)
            postInvalidate()
        }

    }

}