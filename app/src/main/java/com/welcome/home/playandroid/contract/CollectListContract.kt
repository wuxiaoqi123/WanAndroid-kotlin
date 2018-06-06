package com.welcome.home.playandroid.contract

import com.welcome.home.playandroid.base.IPresenter
import com.welcome.home.playandroid.base.IView
import com.welcome.home.playandroid.bean.CollectList

class CollectListContract {
    interface View : IView {
        fun setCollectList(collectList: CollectList)
    }

    interface Presenter : IPresenter {
        fun getCollectList()
    }
}