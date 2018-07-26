package com.welcome.home.playandroid.util

import android.content.Context
import android.util.AttributeSet
import com.tencent.smtt.sdk.WebSettings
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient

class X5WebView : WebView {
    val client: WebViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(p0: WebView?, p1: String?): Boolean {
            p0?.loadUrl(p1)
            return true
        }
    }

    constructor(p0: Context?) : super(p0) {
        setBackgroundColor(85621)
    }

    constructor(p0: Context?, p1: AttributeSet?) : super(p0, p1) {
        this.webViewClient = client
        initWebViewSettings()
        this.view.isClickable = true
    }


    private fun initWebViewSettings() {
        val webSetting = settings
        webSetting.javaScriptEnabled = true
        webSetting.javaScriptCanOpenWindowsAutomatically = true
        webSetting.allowFileAccess = true
        webSetting.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        webSetting.setSupportZoom(true)
        webSetting.builtInZoomControls = true
        webSetting.useWideViewPort = true
        webSetting.setSupportMultipleWindows(true)
        webSetting.setAppCacheEnabled(true)
        webSetting.domStorageEnabled = true
        webSetting.setGeolocationEnabled(true)
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE)
        webSetting.pluginState = WebSettings.PluginState.ON_DEMAND
        webSetting.cacheMode = WebSettings.LOAD_NO_CACHE
    }

}