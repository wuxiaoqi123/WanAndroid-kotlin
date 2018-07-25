package com.welcome.home.playandroid.fragment

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.base.BaseFragment
import com.welcome.home.playandroid.util.SharedPreferenceUtils

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/07/08
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyFragment : BaseFragment() {

    private var loginNameTv: TextView? = null
    private var exitTv: TextView? = null
    private var collectionsTv: TextView? = null
    private var versionTv: TextView? = null
    private var showVersionTv: TextView? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_my
    }

    override fun initView(savedInstanceState: Bundle?) {
        showVersionTv?.setText("v ${getVersionName()}")
    }

    override fun initListener() {
        loginNameTv?.setOnClickListener { v ->
            if (!TextUtils.isEmpty(SharedPreferenceUtils.getStringData("username", ""))) {
//                return@loginNameTv.setOnClickListener
            }
//            RegisterOrLoginActivity.startActivity(activity)
        }
        exitTv?.setOnClickListener { v -> showDialog() }
        versionTv?.setOnClickListener { v -> Toast.makeText(mContext, "v" + getVersionName(), Toast.LENGTH_SHORT).show() }
//        collectionsTv.setOnClickListener { v -> CollectionActivity.startActivity(activity) }
    }

    override fun lazyFetchData() {

    }

    private fun getVersionName(): String {
        var versionName = ""
        val packageManager = activity?.packageManager
        try {
            val packageInfo = packageManager!!.getPackageInfo(activity?.packageName, 0)
            versionName = packageInfo.versionName
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return versionName
    }

    private fun showDialog() {
        AlertDialog.Builder(context!!)
                .setTitle("提示")
                .setMessage("确定退出登录")
                .setNegativeButton("确定") { dialog, which ->
                    SharedPreferenceUtils.clear()
//                    exitTv.setVisibility(View.GONE)
//                    loginNameTv.setText(getString(R.string.register_or_login))
//                    collectionsTv.setVisibility(View.GONE)
                }
                .setPositiveButton("取消", null)
                .setCancelable(true)
                .show()
    }
}