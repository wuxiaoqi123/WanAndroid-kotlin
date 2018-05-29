package com.welcome.home.playandroid.contract

import com.welcome.home.playandroid.base.IPresenter
import com.welcome.home.playandroid.base.IView
import com.welcome.home.playandroid.bean.LoginBean

class RegisterOrLoginContract {
    interface View : IView {
        fun register(loginBean: LoginBean)

        fun login(loginBean: LoginBean)
    }

    interface Presenter : IPresenter {
        fun register(username: String, pwd: String, repwd: String)

        fun login(username: String, pwd: String)
    }
}