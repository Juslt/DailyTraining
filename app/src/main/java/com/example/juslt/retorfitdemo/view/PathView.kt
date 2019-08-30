package com.example.juslt.retorfitdemo.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

/**
 * Created by Juslt on 2019/7/31
 */
class PathView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, def: Int = 0) :
    View(context, attributeSet, def) {

    private val mPaint: Paint by lazy { Paint() }
    private var mWidth = 0f
    private var mHeight = 0

    private var offset = 0

    init {
        mPaint.color = Color.RED
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 10f



    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w.toFloat()
        mHeight = h

        val animator = ValueAnimator.ofInt(0, mWidth.toInt())
        animator.duration = 1000
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener { animation ->
            run {
                offset = animation.animatedValue as Int
                postInvalidate()
            }
        }
        animator.start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val path = Path()

        canvas?.translate(0f, (mHeight / 2).toFloat())

        path.moveTo(-mWidth, 0f)

        path.quadTo(-mWidth * 3 / 4+offset, -60f, -mWidth * 1 / 2+offset, 0f)
        path.quadTo(-mWidth * 1 / 4+offset, 60f, 0f+offset, 0f)
        path.quadTo(mWidth * 1 / 4+offset, -60f, mWidth * 1 / 2+offset, 0f)
        path.quadTo(mWidth * 3 / 4+offset, 60f, mWidth+offset, 0f)
        canvas?.drawPath(path, mPaint)





//        canvas?.translate((mWidth/2).toFloat(), (mHeight/2).toFloat())
//        canvas?.scale(1f,-1f)
//
//        val path = Path()
//        path.addCircle(0f,0f,100f,Path.Direction.CW)
//
//
//        val dst = Path()
//        dst.addRect(RectF(-200f,-200f,200f,200f),Path.Direction.CW)
//
//        path.offset(300f,0f,dst)
//        canvas?.drawPath(path,mPaint)
//
//        mPaint.color = Color.BLACK
//        canvas?.drawPath(dst,mPaint)

//        path.lineTo(100f,100f)
//
//        val oval = RectF(0f,0f,300f,300f)
//        path.arcTo(oval,0f,270f,true)
//        path.lineTo(500f,500f)

//        path.addArc(oval,0f,270f)


//        val path = Path()
//        var src = Path()
//
//        path.addRect(-200f,-200f,200f,200f,Path.Direction.CW)
//
//        src.addCircle(0f,0f,100f,Path.Direction.CW)
//
//        path.addPath(src,0f,100f)


//        path.addRect(-200f,-200f,200f,200f,Path.Direction.CW)
//        path.addRect(-200f,-200f,200f,200f,Path.Direction.CCW)
//        path.setLastPoint(-300f,300f)

//        path.lineTo(200f,200f)
//        path.moveTo(200f,100f)
//        path.setLastPoint(200f,100f)
//        path.lineTo(200f,0f)
//        path.close()

    }
}