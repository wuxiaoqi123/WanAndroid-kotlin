package com.welcome.home.playandroid.contract

import com.welcome.home.playandroid.base.IPresenter
import com.welcome.home.playandroid.base.IView
import com.welcome.home.playandroid.bean.CollectArticleList

class CollectContract {
    interface View : IView {
        fun collectSuccess(collectArticleList: CollectArticleList)
    }

    interface Presenter : IPresenter {
        fun collectArticle(title: String, author: String, link: String)
    }
}