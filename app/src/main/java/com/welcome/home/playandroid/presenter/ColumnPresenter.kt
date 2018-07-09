package com.welcome.home.playandroid.presenter

import com.welcome.home.playandroid.contract.ColumnContract

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/07/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ColumnPresenter : ColumnContract.Presenter {

    private var mView: ColumnContract.View? = null

    constructor(view: ColumnContract.View) {
        this.mView = view
    }

    override fun getColumnList() {

    }
}