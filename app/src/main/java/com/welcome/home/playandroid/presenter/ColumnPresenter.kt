package com.welcome.home.playandroid.presenter

import com.welcome.home.playandroid.bean.ColumnList
import com.welcome.home.playandroid.contract.ColumnContract
import com.welcome.home.playandroid.net.api.WanAndroidApi
import com.welcome.home.playandroid.net.callback.RxObserver
import com.welcome.home.playandroid.net.exception.ResponeThrowable
import com.welcome.home.playandroid.net.http.HttpUtils
import com.welcome.home.playandroid.net.transformer.DefaultTransformer

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
        HttpUtils.Singleton.instance.getRetrofitClient().build(WanAndroidApi::class.java)!!
                .getColumnList()
                .compose(DefaultTransformer())
                .compose(mView!!.bindToLife<MutableList<ColumnList>>())
                .subscribe(object : RxObserver<MutableList<ColumnList>>() {
                    override fun onFail(ex: ResponeThrowable) {
                        mView!!.showErrMsg(ex.message!!)
                    }

                    override fun onSuccess(columnLists: MutableList<ColumnList>) {
                        mView!!.setColumnList(columnLists)
                    }
                })
    }
}