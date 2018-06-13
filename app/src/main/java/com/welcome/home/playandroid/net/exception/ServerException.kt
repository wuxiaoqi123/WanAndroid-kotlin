package com.welcome.home.playandroid.net.exception

class ServerException : RuntimeException {
    val code: Int
    val msg: String

    constructor(code: Int, message: String) {
        this.code = code
        this.msg = message
    }
}