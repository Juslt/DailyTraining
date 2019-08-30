package com.example.juslt.retorfitdemo.stick_layout

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Created by Juslt on 2019/8/8
 */
class HeaderView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, attribute: Int = 0) :
    View(context, attributeSet, attribute) {
    init {
        requestLayout()
    }
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

}