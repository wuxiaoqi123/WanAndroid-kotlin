package com.welcome.home.playandroid.activity

import android.os.Handler
import android.view.animation.AccelerateInterpolator
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initWindow() {
    }

    override fun initData() {
    }

    override fun initViews() {
    }

    override fun initListener() {
        splash_activity_tv.animate()
                .alpha(1.0f)
                .setDuration(1000)
                .setInterpolator(AccelerateInterpolator())
                .start()
        Handler().postDelayed(Runnable {
            if (isFinishing) return@Runnable
            MainActivity.startActivity(this)
            finish()
        }, 2300)
    }
}