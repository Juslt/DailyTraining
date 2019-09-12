package com.example.juslt.retorfitdemo.view

import android.content.Context
import android.support.v4.widget.ViewDragHelper
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout

/**
 * Created by Juslt on 2019/8/2
 */
class DrawView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defAttr: Int = 0) :
    LinearLayout(context, attributeSet, defAttr) {

    private var mDragHelper: ViewDragHelper? = null

    init {
        mDragHelper = ViewDragHelper.create(this, 1f, ViewDragCallback(paddingLeft, width, paddingTop, height))
        requestLayout()
        invalidate()
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        when (ev?.action) {
            MotionEvent.ACTION_CANCEL -> {
                mDragHelper?.cancel()
            }
            MotionEvent.ACTION_DOWN -> {
                mDragHelper?.cancel()
            }
        }
        return mDragHelper!!.shouldInterceptTouchEvent(ev!!)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        mDragHelper!!.processTouchEvent(event!!)
        return true
    }

    class ViewDragCallback(
        private val paddingLeft: Int,
        private val width: Int,
        private val paddingTop: Int,
        private val height: Int
    ) : ViewDragHelper.Callback() {
        override fun tryCaptureView(p0: View, p1: Int): Boolean {
            return true
        }

        override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
            if (paddingLeft > left) {
                return paddingLeft
            }
            if (width - child.width < left) {
                return width - child.width
            }
            return left
        }

        override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
            if (paddingTop > top) {
                return paddingTop
            }

            if (height - child.height < top) {
                return height - child.height
            }
            return top
        }


        override fun onViewDragStateChanged(state: Int) {
            when (state) {
                ViewDragHelper.STATE_DRAGGING -> {

                }
                ViewDragHelper.STATE_IDLE -> {

                }
                ViewDragHelper.STATE_SETTLING -> {

                }
            }
            super.onViewDragStateChanged(state)
        }

    }

}