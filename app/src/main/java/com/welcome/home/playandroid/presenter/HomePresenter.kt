package com.welcome.home.playandroid.presenter

import com.welcome.home.playandroid.bean.BannerList
import com.welcome.home.playandroid.bean.HomeList
import com.welcome.home.playandroid.contract.HomeContract
import com.welcome.home.playandroid.net.api.WanAndroidApi
import com.welcome.home.playandroid.net.callback.RxObserver
import com.welcome.home.playandroid.net.exception.ResponeThrowable
import com.welcome.home.playandroid.net.http.HttpUtils
import com.welcome.home.playandroid.net.transformer.DefaultTransformer

class HomePresenter(view: HomeContract.View) : HomeContract.Presenter {

    private var mView: HomeContract.View? = view

    override fun loadBannerList() {
        HttpUtils.getInstance().getRetrofitClient()
                .build(WanAndroidApi::class.java)!!
                .getBannerList()
                .compose(DefaultTransformer())
                .compose(mView!!.bindToLife())
                .subscribe(object : RxObserver<MutableList<BannerList>>() {
                    override fun onFail(e: ResponeThrowable) {
                        mView!!.showErrMsg(e.msg!!)
                    }

                    override fun onSuccess(t: MutableList<BannerList>) {
                        mView!!.setBannerList(t)
                    }
                })
    }

    override fun loadHomeList(page: Int) {
        HttpUtils.getInstance().getRetrofitClient()
                .build(WanAndroidApi::class.java)!!
                .getHomeList(page)
                .compose(DefaultTransformer())
                .compose(mView!!.bindToLife())
                .subscribe(object : RxObserver<HomeList>() {
                    override fun onFail(e: ResponeThrowable) {
                        mView!!.showErrMsg(e.msg!!)
                    }

                    override fun onSuccess(t: HomeList) {
                        if (page == 0) {
                            mView?.setHomeList(t)
                        } else {
                            mView?.addHomeList(t)
                        }
                    }
                })
    }
}