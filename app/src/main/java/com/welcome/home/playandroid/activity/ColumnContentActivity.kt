package com.welcome.home.playandroid.activity

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.adapter.ColumnContentAdapter
import com.welcome.home.playandroid.base.BaseActivity
import com.welcome.home.playandroid.bean.ColumnContentList
import com.welcome.home.playandroid.contract.ColumnContentContract
import com.welcome.home.playandroid.presenter.ColumnContentPresenter
import com.welcome.home.playandroid.util.SmartRefreshLayoutUtils
import kotlinx.android.synthetic.main.activity_collection.*

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/07/31
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ColumnContentActivity : BaseActivity(), ColumnContentContract.View {

    companion object {
        val KEY_CID = "key_cid"

        fun startActivity(activity: Context, cid: Int) {
            val intent = Intent(activity, ColumnContentActivity::class.java)
            intent.putExtra(KEY_CID, cid)
            activity.startActivity(intent)
        }
    }

    private var c_id = 0
    private var page = 0

    private var mAdapter: ColumnContentAdapter? = null
    private var presenterImp: ColumnContentPresenter? = null

    override fun initWindow() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_column_content
    }

    override fun initData() {
        c_id = intent.getIntExtra(KEY_CID, 0)
    }

    override fun initViews() {
        val supportActionBar = supportActionBar
        if (supportActionBar == null) {
            setSupportActionBar(toolbar)
            getSupportActionBar()!!.setTitle("")
            getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        }
        initRefreshLayout()
        refresh_content_recyclerview.setLayoutManager(LinearLayoutManager(this))
        mAdapter = ColumnContentAdapter(this)
        refresh_content_recyclerview.setAdapter(mAdapter)
        presenterImp = ColumnContentPresenter(this)
        presenterImp?.getColumnContent(page, c_id)
    }

    private fun initRefreshLayout() {
        SmartRefreshLayoutUtils.initRefreshLayoutBz(this, refresh_content_smart_layout)
    }

    override fun initListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setColumnContent(columnContentList: ColumnContentList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addColumnContent(columnContentList: ColumnContentList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrMsg(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}