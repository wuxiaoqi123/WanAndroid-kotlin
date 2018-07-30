package com.welcome.home.playandroid.activity

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.adapter.CollectionListAdapter
import com.welcome.home.playandroid.base.BaseActivity
import com.welcome.home.playandroid.bean.CollectList
import com.welcome.home.playandroid.contract.CollectListContract
import kotlinx.android.synthetic.main.activity_collection.*

class CollectionActivity : BaseActivity(), CollectListContract.View {

    private var smartRefreshLayout: SmartRefreshLayout? = null
    private var recyclerView: RecyclerView? = null

    private var mAdatper: CollectionListAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_collection;
    }


    override fun initWindow() {

    }

    override fun initData() {

    }

    override fun initViews() {
        smartRefreshLayout = refresh_content_smart_layout
        recyclerView = refresh_content_recyclerview
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val supportActionBar = supportActionBar
        if (supportActionBar == null) {
            setSupportActionBar(toolbar)
            getSupportActionBar()!!.setTitle("")
            getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        }
        smartRefreshLayout?.setEnableAutoLoadMore(false)
        smartRefreshLayout?.setEnableRefresh(false)
        recyclerView?.setLayoutManager(LinearLayoutManager(this))
        mAdatper = CollectionListAdapter(this)
        recyclerView?.setAdapter(mAdatper)
//        val presenterImp = CollectListPresenter(this)
//        presenterImp.getCollectList()
    }

    override fun initListener() {

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setCollectList(collectList: CollectList) {
        mAdatper?.setHomeList(collectList.datas)
    }

    override fun showErrMsg(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}