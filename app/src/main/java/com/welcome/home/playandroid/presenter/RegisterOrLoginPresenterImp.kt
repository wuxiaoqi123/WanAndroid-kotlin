package com.welcome.home.playandroid.presenter

import com.welcome.home.playandroid.contract.RegisterOrLoginContract

class RegisterOrLoginPresenterImp(view: RegisterOrLoginContract.View) : RegisterOrLoginContract.Presenter {

    var mView: RegisterOrLoginContract.View? = view

    override fun register(username: String, pwd: String, repwd: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun login(username: String, pwd: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}