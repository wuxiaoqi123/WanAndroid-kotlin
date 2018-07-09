package com.welcome.home.playandroid.fragment

import android.os.Bundle
import android.widget.ExpandableListView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.trello.rxlifecycle2.LifecycleTransformer
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.adapter.ColumnExpandableListViewAdapter
import com.welcome.home.playandroid.base.BaseFragment
import com.welcome.home.playandroid.bean.ColumnList
import com.welcome.home.playandroid.contract.ColumnContract
import com.welcome.home.playandroid.presenter.ColumnPresenter

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

    companion object {
        fun getInstance(): ColumnFragment {
            return ColumnFragment()
        }
    }

    private var smartRefreshLayout: SmartRefreshLayout? = null
    private var expandableListView: ExpandableListView? = null

    private var mAdapter: ColumnExpandableListViewAdapter? = null
    private var presenterImp: ColumnPresenter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_column
    }

    override fun lazyFetchData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initView(savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setColumnList(list: List<ColumnList>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrMsg(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T> bindToLife(): LifecycleTransformer<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}