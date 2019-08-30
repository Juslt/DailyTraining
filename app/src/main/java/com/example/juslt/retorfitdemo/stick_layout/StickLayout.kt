package com.example.juslt.retorfitdemo.stick_layout

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.View
import android.view.ViewConfiguration
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Scroller
import com.example.juslt.retorfitdemo.R

/**
 * Created by Juslt on 2019/8/8
 */
class StickLayout @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, def: Int = 0) :
    LinearLayout(context, attributeSet, def) {

    private var headHeight = 0
    private var lastX = 0f
    private var lastY = 0f

    private var isListViewControlled = false
    private var isSticky = false


    private var headerView: View? = null
    private var listView: ListView? = null

    private val slop by lazy { ViewConfiguration.get(context).scaledTouchSlop }
    private val mMaxVelocity by lazy { ViewConfiguration.get(context).scaledMaximumFlingVelocity }
    private val mMinVelocity by lazy { ViewConfiguration.get(context).scaledMinimumFlingVelocity }

    private val velocityTracker: VelocityTracker by lazy { VelocityTracker.obtain() }
    private val mScroller by lazy { Scroller(context) }
    private var mDirection = DIRECTION.UP

    private var velocityY = 0f

    private var mLastScrollerY: Int = 0
    internal enum class DIRECTION {
        UP, DOWN
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        headerView = findViewById(R.id.head_view)
        listView = findViewById(R.id.list_view)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        headHeight = headerView!!.height
        val measureSpec =
            MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec) + headHeight, MeasureSpec.EXACTLY)
        val heightSpec = MeasureSpec.getSize(measureSpec)
        super.onMeasure(widthMeasureSpec, heightSpec)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {


        when (ev!!.action) {
            MotionEvent.ACTION_DOWN -> {

            }
            MotionEvent.ACTION_MOVE -> {
                velocityTracker.addMovement(ev)
                velocityTracker.computeCurrentVelocity(1000)
                velocityY = velocityTracker.yVelocity

                val deltaY = ev.y - lastY
                if (Math.abs(deltaY) > slop && deltaY > 0 && isSticky && isListTop() && isListViewControlled) {
                    ev.action = MotionEvent.ACTION_DOWN
                    isListViewControlled = false
                    dispatchTouchEvent(ev)

                    ev.action = MotionEvent.ACTION_CANCEL
                }
            }
            MotionEvent.ACTION_UP -> {
                Log.e("===", "velocityY:$velocityY")
                mDirection = if (velocityY < 0) DIRECTION.UP else DIRECTION.DOWN
                if (Math.abs(velocityY) > mMinVelocity) {
                    fling(-velocityY)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    private fun fling(velocityY: Float) {
        mScroller.fling(0, scrollY, 0, velocityY.toInt(), 0, Int.MAX_VALUE, 0, Int.MAX_VALUE)
        mLastScrollerY = mScroller.currY
        postInvalidate()
    }

    override fun computeScroll() {
        if (mScroller.computeScrollOffset()) {
            val curY = mScroller.currY
            if (mDirection == DIRECTION.UP) {
                if (!isSticky) {
                    scrollTo(0, curY)
                }
            } else {
                if (isListTop()) {
                    val delta = curY -mLastScrollerY
                    val toY = scrollY+delta
                    scrollTo(0, toY)
                    if(scrollY==0 && !mScroller.isFinished){
                        mScroller.forceFinished(true)
                    }
                }
                invalidate()
            }
            mLastScrollerY = curY
        }
    }


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        val x = ev!!.x
        val y = ev.y
        when (ev.action) {

            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
            }

            MotionEvent.ACTION_MOVE -> {
                val deltaX = x - lastX
                val deltaY = y - lastY

                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    return false
                } else if (Math.abs(deltaY) > slop) {
                    if (!isSticky || isSticky && deltaY > 0 && isListTop()) {        // 需要拦截的状态 ，1、header显示时  2、header隐藏并且listView下滑滑动到顶部时
                        isListViewControlled = false
                        lastY = y
                        return true
                    } else {
                        isListViewControlled = true
                    }
                }
            }

            MotionEvent.ACTION_UP -> {

            }

        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                val deltaY = event.y - lastY
                scrollBy(0, (-deltaY).toInt())
                lastY = event.y
                if (isSticky) {
                    event.action = MotionEvent.ACTION_DOWN
                    dispatchTouchEvent(event)
                    event.action = MotionEvent.ACTION_CANCEL
                }
            }
        }

        return super.onTouchEvent(event)
    }


    override fun scrollTo(x: Int, y: Int) {
        var temp = y
        if (temp < 0) {
            temp = 0
        }
        if (temp > headHeight) {
            temp = headHeight
        }

        isSticky = temp == headHeight

        super.scrollTo(x, temp)
    }

    private fun isListTop(): Boolean {
        if (listView != null) {
            val childAt = listView!!.getChildAt(0)
            val firstPosition = listView!!.firstVisiblePosition
            if (childAt == null || firstPosition == 0 && childAt.top == 0) {
                return true
            }
        }
        return false
    }
}