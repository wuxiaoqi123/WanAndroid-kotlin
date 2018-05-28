package com.welcome.home.playandroid.activity

import android.content.Context
import android.content.Intent
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun initWindow() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initViews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity.javaClass)
            context.startActivity(intent)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}
