package com.doyou.practicelayout1

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.util.Log

/**
 * 需求：需要把它写成正方形的ImageView
 * @autor hongbing
 * @date 2019-08-02
 */
class SquareImageView : AppCompatImageView {

    private val TAG = "SquareImageView"
    private val mContext: Context? = null
    private val mBmp: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.fighting_avatar)

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setImageBitmap(mBmp)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var measureWidth = measuredWidth
        var heightMeasure = measuredHeight
        if (measureWidth > heightMeasure) {
            measureWidth = heightMeasure
        }else{
            heightMeasure = measureWidth
        }
        Log.d(TAG, "width = $measureWidth->height = $heightMeasure")
        setMeasuredDimension(measureWidth, heightMeasure)
    }

}