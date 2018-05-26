package com.welcome.home.playandroid.app

import android.app.Application
import android.content.Context
import android.util.Log
import com.facebook.drawee.backends.pipeline.Fresco
import com.tencent.smtt.sdk.QbSdk

class PlayAndroidApplication : Application() {

    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this;
        Fresco.initialize(appContext)
        initTencentX5()
    }

    private fun initTencentX5() {
        val cb = object : QbSdk.PreInitCallback {
            override fun onViewInitFinished(p0: Boolean) {
                Log.d("app", "onViewInitFinished is " + p0)
            }

            override fun onCoreInitFinished() {
            }
        }
        QbSdk.initX5Environment(appContext, cb)
    }
}