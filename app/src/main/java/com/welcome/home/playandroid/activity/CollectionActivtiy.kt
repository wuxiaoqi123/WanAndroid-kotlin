package com.welcome.home.playandroid.activity

import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.base.BaseActivity
import com.welcome.home.playandroid.bean.CollectList
import com.welcome.home.playandroid.contract.CollectListContract

class CollecationActivity : BaseActivity(), CollectListContract.View {
    override fun getLayoutId(): Int {
        return R.layout.activity_collection;
    }

    override fun initWindow() {
    }

    override fun initData() {
    }

    override fun initViews() {
    }

    override fun initListener() {
    }

    override fun setCollectList(collectList: CollectList) {
    }

    override fun showErrMsg(msg: String) {
    }
}