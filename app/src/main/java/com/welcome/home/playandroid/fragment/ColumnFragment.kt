package com.welcome.home.playandroid.fragment

import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.Toast
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.adapter.ColumnExpandableListViewAdapter
import com.welcome.home.playandroid.base.BaseFragment
import com.welcome.home.playandroid.bean.ColumnList
import com.welcome.home.playandroid.contract.ColumnContract
import com.welcome.home.playandroid.presenter.ColumnPresenter
import com.welcome.home.playandroid.util.SmartRefreshLayoutUtils

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/07/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ColumnFragment : BaseFragment(), ColumnContract.View {

    private var smartRefreshLayout: SmartRefreshLayout? = null
    private var expandableListView: ExpandableListView? = null

    private var mAdapter: ColumnExpandableListViewAdapter? = null
    private var presenterImp: ColumnPresenter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_column
    }

    override fun initView(savedInstanceState: Bundle?) {
        smartRefreshLayout = rootView!!.findViewById(R.id.refresh_content_smart_layout)
        expandableListView = rootView!!.findViewById(R.id.fragment_column_expandable_listview)
        mAdapter = ColumnExpandableListViewAdapter(activity!!)
        expandableListView!!.setAdapter(mAdapter)
        presenterImp = ColumnPresenter(this)
        initRefreshLayout()
    }

    private fun initRefreshLayout() {
        SmartRefreshLayoutUtils.initRefreshLayoutBz(activity!!, smartRefreshLayout!!)
        smartRefreshLayout?.setEnableLoadMore(false)
        smartRefreshLayout?.setOnRefreshListener({ presenterImp?.getColumnList() })
    }

    override fun lazyFetchData() {
        presenterImp?.getColumnList()
    }

    override fun initListener() {
    }

    override fun setColumnList(list: MutableList<ColumnList>) {
        smartRefreshLayout?.finishRefresh()
        mAdapter?.setColumnLists(list)
    }

    override fun showErrMsg(msg: String) {
        Toast.makeText(activity!!, msg, Toast.LENGTH_LONG).show()
    }
}