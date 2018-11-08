package com.welcome.home.playandroid.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import cn.bingoogolapple.bgabanner.BGABanner
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.adapter.HomeBannerAdapter
import com.welcome.home.playandroid.adapter.HomeListAdapter
import com.welcome.home.playandroid.base.BaseFragment
import com.welcome.home.playandroid.bean.BannerList
import com.welcome.home.playandroid.bean.HomeList
import com.welcome.home.playandroid.contract.HomeContract
import com.welcome.home.playandroid.presenter.HomePresenter
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
class HomeFragment : BaseFragment(), HomeContract.View, BGABanner.Delegate<View, Any> {

    private var smartRefreshLayout: SmartRefreshLayout? = null
    private var recyclerView: RecyclerView? = null
    private var mPresenter: HomePresenter? = null
    private var page = 0
    private var mAdapter: HomeListAdapter? = null
    private var mHeadBanner: BGABanner? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView(savedInstanceState: Bundle?) {
        smartRefreshLayout = rootView?.findViewById(R.id.refresh_content_smart_layout)
        recyclerView = rootView?.findViewById(R.id.refresh_content_recyclerview)
        recyclerView?.layoutManager = LinearLayoutManager(activity!!)
        mAdapter = HomeListAdapter(activity!!)
        recyclerView?.adapter = mAdapter
        val headView = mAdapter?.setHeaderView(R.layout.item_head_view)
        mHeadBanner = headView?.findViewById(R.id.recommed_banner)
        val homeBannderAdapter = HomeBannerAdapter()
        mHeadBanner?.setDelegate(this)
        mHeadBanner?.setAdapter(homeBannderAdapter)
        mPresenter = HomePresenter(this)
        initRefreshLayout()
    }

    private fun initRefreshLayout() {
        SmartRefreshLayoutUtils.initRefreshLayoutBz(activity!!, smartRefreshLayout!!)
        smartRefreshLayout?.setEnableLoadMore(true)
        smartRefreshLayout?.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                page++
                mPresenter?.loadBannerList()
                mPresenter?.loadHomeList(page)
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                page = 0
                mPresenter?.loadHomeList(page)
            }
        })
    }

    override fun setBannerList(bannerList: List<BannerList>) {
        smartRefreshLayout?.finishRefresh()
        mHeadBanner?.setData(R.layout.item_image_banner, bannerList, null)
        mAdapter?.notifyDataSetChanged()
    }

    override fun setHomeList(homeList: HomeList) {
        smartRefreshLayout?.finishRefresh()
        mAdapter?.setHomeList(homeList)
    }

    override fun addHomeList(homeList: HomeList) {
        smartRefreshLayout?.finishLoadMore()
        mAdapter?.addHomeList(homeList)
    }

    override fun showErrMsg(msg: String) {
        Toast.makeText(activity!!, msg, Toast.LENGTH_LONG).show()
    }

    override fun lazyFetchData() {
        mPresenter?.loadBannerList()
        mPresenter?.loadHomeList(0)
    }

    override fun initListener() {
    }

    override fun onBannerItemClick(banner: BGABanner?, itemView: View?, model: Any?, position: Int) {
        if (model is BannerList) {
            //TODO
        }
    }
}