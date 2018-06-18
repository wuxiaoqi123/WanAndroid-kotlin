package com.welcome.home.playandroid.net.response

data class HttpResponse<T>(val errorCode: Int?,
                           val errorMsg: String?,
                           val data: T)