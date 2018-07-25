package com.welcome.home.playandroid.presenter

import com.welcome.home.playandroid.bean.CollectArticleList
import com.welcome.home.playandroid.contract.CollectContract
import com.welcome.home.playandroid.net.api.WanAndroidApi
import com.welcome.home.playandroid.net.callback.RxObserver
import com.welcome.home.playandroid.net.exception.ResponeThrowable
import com.welcome.home.playandroid.net.http.HttpUtils
import com.welcome.home.playandroid.net.transformer.DefaultTransformer

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/07/25
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class CollectPresenter(view: CollectContract.View) : CollectContract.Presenter {

    private var mView: CollectContract.View? = view

    override fun collectArticle(title: String, author: String, link: String) {
        HttpUtils.getInstance().getRetrofitClient()
                .build(WanAndroidApi::class.java)!!
                .collectArticle(title, author, link)
                .compose(DefaultTransformer())
                .compose(mView!!.bindToLife())
                .subscribe(object : RxObserver<CollectArticleList>() {
                    override fun onFail(e: ResponeThrowable) {
                        mView?.showErrMsg(e.msg!!)
                    }

                    override fun onSuccess(t: CollectArticleList) {
                        mView?.collectSuccess(t)
                    }
                })
    }
}