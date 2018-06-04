package com.welcome.home.playandroid.contract

import com.welcome.home.playandroid.base.IView

class CollectContract{
    interface View : IView {
        fun collectSuccess()
    }
}