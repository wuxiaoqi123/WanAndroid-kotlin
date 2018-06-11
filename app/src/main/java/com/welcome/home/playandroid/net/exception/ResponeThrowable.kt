package com.welcome.home.playandroid.net.exception


class ResponeThrowable : Exception {
    var code: Int = 0

    var msg: String? = null

    constructor(throwable: Throwable, code: Int) : super(throwable) {
        this.code = code
    }

    constructor(throwable: Throwable, code: Int, msg: String) : super(throwable) {
        this.code = code
        this.msg = msg
    }
}