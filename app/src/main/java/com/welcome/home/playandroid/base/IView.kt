package com.welcome.home.playandroid.base

import com.trello.rxlifecycle2.LifecycleTransformer

interface IView {

    fun showErrMsg(msg: String)

    fun <T> bindToLife(): LifecycleTransformer<T>
}