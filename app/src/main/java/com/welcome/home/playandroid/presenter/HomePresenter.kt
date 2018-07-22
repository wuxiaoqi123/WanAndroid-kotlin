package com.welcome.home.playandroid.presenter

import com.welcome.home.playandroid.contract.HomeContract

class HomePresenter(view: HomeContract.View) : HomeContract.Presenter {

    private var mView: HomeContract.View? = view

    override fun loadBannerList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadHomeList(page: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}