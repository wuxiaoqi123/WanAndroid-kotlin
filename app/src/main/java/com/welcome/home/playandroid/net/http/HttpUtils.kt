package com.welcome.home.playandroid.net.http

import com.welcome.home.playandroid.net.config.NetWorkConfiguration
import okhttp3.OkHttpClient

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/07/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class HttpUtils {
    companion object {
        val TAG = "HttpUtils"
        var mInstance: HttpUtils? = null

    }

    private var mOkHttpClient: OkHttpClient? = null
    private var configuration: NetWorkConfiguration? = null

}