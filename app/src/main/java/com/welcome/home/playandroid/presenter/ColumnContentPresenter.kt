package com.welcome.home.playandroid.presenter

import com.welcome.home.playandroid.contract.ColumnContentContract

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/08/01
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ColumnContentPresenter(view: ColumnContentContract.View) : ColumnContentContract.Presenter {

    private var mView: ColumnContentContract.View = view

    override fun getColumnContent(page: Int, c_id: Int) {

    }
}