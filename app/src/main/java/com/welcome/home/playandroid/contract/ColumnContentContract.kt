package com.welcome.home.playandroid.contract

import com.welcome.home.playandroid.base.IPresenter
import com.welcome.home.playandroid.base.IView
import com.welcome.home.playandroid.bean.ColumnContentList

class ColumnContentContract {

    interface View : IView {
        fun setColumnContent(columnContentList: ColumnContentList)

        fun addColumnContent(columnContentList: ColumnContentList)
    }

    interface Presenter : IPresenter {
        fun getColumnContent(page: Int, c_id: Int)
    }
}