package com.welcome.home.playandroid.activity

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.base.BaseActivity
import com.welcome.home.playandroid.presenter.RegisterOrLoginPresenterImp
import kotlinx.android.synthetic.main.activity_collection.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    val HOME_PAGE = 0
    val COLUMN_PAGE = 1
    val ME_PAGE = 2

    var mCurrentTag: String? = null
    var mCurrentFragment: Fragment? = null
    var presenterImp: RegisterOrLoginPresenterImp? = null
    var lastClickTime: Long = 0


    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity.javaClass)
            context.startActivity(intent)
        }
    }

    override fun initWindow() {
        TODO("not impleme nted") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initViews() {
        if (supportActionBar == null) {
            setSupportActionBar(toolbar)
            supportActionBar?.title = ""
        }
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

    }

    override fun initListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}
