package com.welcome.home.playandroid.contract

import com.welcome.home.playandroid.base.IPresenter
import com.welcome.home.playandroid.base.IView
import com.welcome.home.playandroid.bean.ColumnList

class ColumnContract {

    interface View : IView {
        fun setColumnList(list: MutableList<ColumnList>)
    }

    interface Presenter : IPresenter {
        fun getColumnList()
    }
}