package com.welcome.home.playandroid.fragment

import android.os.Bundle
import android.widget.ExpandableListView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.base.BaseFragment
import com.welcome.home.playandroid.bean.BannerList
import com.welcome.home.playandroid.bean.HomeList
import com.welcome.home.playandroid.contract.HomeContract
import com.welcome.home.playandroid.util.SmartRefreshLayoutUtils

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/07/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class HomeFragment : BaseFragment(), HomeContract.View {

    private var smartRefreshLayout: SmartRefreshLayout? = null
    private var expandableListeView: ExpandableListView? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_column;
    }


    override fun initView(savedInstanceState: Bundle?) {
        initRefreshLayout()
        smartRefreshLayout = rootView?.findViewById(R.id.refresh_content_smart_layout)
        expandableListeView = rootView?.findViewById(R.id.fragment_column_expandable_listview)
    }

    private fun initRefreshLayout() {
        SmartRefreshLayoutUtils.initRefreshLayoutBz(activity!!, smartRefreshLayout!!)
        smartRefreshLayout?.setEnableLoadMore(false)
        smartRefreshLayout?.setOnRefreshListener { refreshLayout ->
            //            presenterImp.getColumnList()
        }
    }

    override fun setBannerList(bannerList: List<BannerList>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setHomeList(homeList: HomeList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addHomeList(homeList: HomeList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrMsg(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun lazyFetchData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}