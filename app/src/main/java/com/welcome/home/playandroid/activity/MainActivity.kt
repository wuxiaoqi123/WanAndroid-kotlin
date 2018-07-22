package com.welcome.home.playandroid.activity

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.text.TextUtils
import android.widget.Toast
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.base.BaseActivity
import com.welcome.home.playandroid.bean.LoginBean
import com.welcome.home.playandroid.contract.RegisterOrLoginContract
import com.welcome.home.playandroid.fragment.ColumnFragment
import com.welcome.home.playandroid.fragment.HomeFragment
import com.welcome.home.playandroid.fragment.MyFragment
import com.welcome.home.playandroid.net.cache.PersistentCookieStore
import com.welcome.home.playandroid.presenter.RegisterOrLoginPresenterImp
import com.welcome.home.playandroid.util.SharedPreferenceUtils
import kotlinx.android.synthetic.main.activity_collection.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_content_main.*

class MainActivity : BaseActivity(), RegisterOrLoginContract.View {

    val HOME_PAGE = 0
    val COLUMN_PAGE = 1
    val ME_PAGE = 2

    var mCurrentTag: String? = null
    var mCurrentFragment: Fragment? = null
    var presenterImp: RegisterOrLoginPresenterImp? = null
    var lastClickTime: Long = 0


    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun initWindow() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun initViews() {
        if (supportActionBar == null) {
            setSupportActionBar(toolbar)
            supportActionBar?.title = ""
        }
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        setFragment(HOME_PAGE)
        if (!TextUtils.isEmpty(SharedPreferenceUtils.getStringData("username", ""))) {
            val userName = SharedPreferenceUtils.getStringData("username", "")
            val pwd = SharedPreferenceUtils.getStringData("password", "")
            presenterImp = RegisterOrLoginPresenterImp(this)
            val persistentCookieStore = PersistentCookieStore(this)
            persistentCookieStore.removeAll()
            presenterImp?.login(userName, pwd)
        }
    }

    override fun initListener() {
        activity_main_bottomBar.setOnTabSelectListener { tabId ->
            when (tabId) {
                R.id.tab_recommend -> setFragment(HOME_PAGE)
                R.id.tab_column -> setFragment(COLUMN_PAGE)
                R.id.tab_my -> setFragment(ME_PAGE)
            }
        }
    }

    private fun setFragment(index: Int) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        val tag = index.toString()
        if (mCurrentTag != null && !tag.equals(mCurrentTag)) {
            val findFragmentByTag = fm.findFragmentByTag(tag)
            if (findFragmentByTag != null) {
                ft.hide(mCurrentFragment)
                        .show(findFragmentByTag)
                        .commitAllowingStateLoss()
                mCurrentFragment = findFragmentByTag
                mCurrentTag = tag
            } else {
                val childFragment = findFragmentByIndex(index)
                if (childFragment == null) return
                ft.hide(mCurrentFragment)
                        .add(activity_main_root_fl.id, childFragment, tag)
                        .addToBackStack(tag)
                        .commitAllowingStateLoss()
                mCurrentFragment = childFragment
                mCurrentTag = tag
            }
        } else {
            if (mCurrentFragment == null) {
                val childFragment = findFragmentByIndex(index)
                if (childFragment == null) return
                ft.replace(activity_main_root_fl.id, childFragment, tag)
                        .addToBackStack(tag)
                        .commitAllowingStateLoss()
                mCurrentFragment = childFragment
                mCurrentTag = tag
            }
        }
    }

    private fun findFragmentByIndex(index: Int): Fragment? {
        var fragment: Fragment? = null
        when (index) {
            HOME_PAGE -> fragment = HomeFragment()
            COLUMN_PAGE -> fragment = ColumnFragment()
            ME_PAGE -> fragment = MyFragment()
        }
        return fragment
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            if (System.currentTimeMillis() - lastClickTime > 2000) {
                lastClickTime = System.currentTimeMillis()
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_LONG).show()
            } else super.onBackPressed()
        }
    }

    override fun register(loginBean: LoginBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun login(loginBean: LoginBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrMsg(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
