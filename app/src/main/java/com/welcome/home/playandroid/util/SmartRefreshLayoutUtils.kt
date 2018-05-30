package com.welcome.home.playandroid.util

import android.content.Context
import com.scwang.smartrefresh.header.MaterialHeader
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.BallPulseFooter
import com.scwang.smartrefresh.layout.header.BezierRadarHeader
import com.welcome.home.playandroid.R

class SmartRefreshLayoutUtils {

    companion object {
        fun initRefreshLayoutMD(context: Context, smartRefreshLayout: SmartRefreshLayout) {
            val materialHeader = MaterialHeader(context)
            materialHeader.setColorSchemeColors(context.resources.getColor(R.color.colorPrimary))
            smartRefreshLayout.setRefreshHeader(materialHeader)
            smartRefreshLayout.setPrimaryColors(context.resources.getColor(R.color.colorPrimary))
            smartRefreshLayout.setRefreshFooter(BallPulseFooter(context)
                    .setSpinnerStyle(SpinnerStyle.Scale)
                    .setAnimatingColor(context.resources.getColor(R.color.colorPrimary)))
        }

        fun initRefreshLayoutBz(context: Context, smartRefreshLayout: SmartRefreshLayout) {
            val bezierRadarHeader = BezierRadarHeader(context)
            smartRefreshLayout.setRefreshHeader(bezierRadarHeader)
            smartRefreshLayout.setPrimaryColors(context.resources.getColor(R.color.colorPrimary))
            smartRefreshLayout.setRefreshFooter(BallPulseFooter(context)
                    .setSpinnerStyle(SpinnerStyle.Scale)
                    .setAnimatingColor(context.resources.getColor(R.color.colorPrimary)))
        }
    }
}