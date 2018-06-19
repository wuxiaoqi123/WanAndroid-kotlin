package com.welcome.home.playandroid.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.welcome.home.playandroid.R

class TitleView : LinearLayout {

    private var mContext: Context? = null

    private var leftBtn: ImageButton? = null
    private var rightBtn: ImageButton? = null

    private var listener: ITitleOnClicenListener? = null

    private var titleTv: TextView? = null

    fun setListener(listener: ITitleOnClicenListener) {
        this.listener = listener
    }

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        mContext = context
        orientation = LinearLayout.HORIZONTAL
        LayoutInflater.from(mContext).inflate(R.layout.layout_title, this)
        setBackgroundColor(context.resources.getColor(R.color.colorPrimary))

        leftBtn = findViewById(R.id.layout_title_left_btn)
        titleTv = findViewById(R.id.layout_title_text_tv)
        rightBtn = findViewById(R.id.layout_title_right_btn)
        leftBtn!!.setOnClickListener { v ->
            if (listener != null) {
                listener!!.onClickLeft()
            }
        }
        rightBtn!!.setOnClickListener { v ->
            if (listener != null) {
                listener!!.onClickRight()
            }
        }
    }

    fun getRightBtn(): View? {
        return rightBtn
    }

    fun getLeftBtn(): View? {
        return leftBtn
    }

    fun setTitle(title: String) {
        titleTv!!.visibility = View.VISIBLE
        titleTv!!.text = title
        titleTv!!.isSelected = true
    }

    interface ITitleOnClicenListener {
        fun onClickLeft()

        fun onClickRight()
    }
}