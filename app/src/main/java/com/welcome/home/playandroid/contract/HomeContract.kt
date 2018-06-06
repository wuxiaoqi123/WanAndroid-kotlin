package com.welcome.home.playandroid.contract

import com.welcome.home.playandroid.base.IPresenter
import com.welcome.home.playandroid.base.IView
import com.welcome.home.playandroid.bean.BannerList
import com.welcome.home.playandroid.bean.HomeList

class HomeContract {

    interface View : IView {
        fun setBannerList(bannerList: List<BannerList>)

        fun setHomeList(homeList: HomeList)

        fun addHomeList(homeList: HomeList)
    }

    interface Presenter : IPresenter {
        fun loadBannerList()

        fun loadHomeList(page: Int)
    }
}