package com.welcome.home.playandroid.net.exception

import android.net.ParseException
import com.google.gson.JsonParseException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

/**
 * Created by wuxiaoqi on 2018/4/26.
 */

class ExceptionHandler {

    /**
     * 约定异常
     */
    internal object ERROR {
        /**
         * 未知错误
         */
        val UNKNOWN = 1000
        /**
         * 解析错误
         */
        val PARSE_ERROR = 1001
        /**
         * 网络错误
         */
        val NETWORD_ERROR = 1002
        /**
         * 协议出错
         */
        val HTTP_ERROR = 1003

        /**
         * 证书出错
         */
        val SSL_ERROR = 1005

        /**
         * 连接超时
         */
        val TIMEOUT_ERROR = 1006

    }

    companion object {

        //网络异常码
        private val UNAUTHORIZED = 401
        private val FORBIDDEN = 403
        private val NOT_FOUND = 404
        private val REQUEST_TIMEOUT = 408
        private val INTERNAL_SERVER_ERROR = 500
        private val BAD_GATEWAY = 502
        private val SERVICE_UNAVAILABLE = 503
        private val GATEWAY_TIMEOUT = 504

        fun handleException(e: Throwable): ResponeThrowable {
            val ex: ResponeThrowable
            if (e is HttpException) {
                ex = ResponeThrowable(e, ERROR.HTTP_ERROR)
                when (e.code()) {
                    UNAUTHORIZED, FORBIDDEN, NOT_FOUND, REQUEST_TIMEOUT, GATEWAY_TIMEOUT, INTERNAL_SERVER_ERROR, BAD_GATEWAY, SERVICE_UNAVAILABLE -> ex.msg = "无网络,请重试!"
                    else -> ex.msg = "无网络,请重试!"
                }
                return ex
            } else if (e is ServerException) {
                ex = ResponeThrowable(e, e.code)
                ex.msg = e.message
                return ex
            } else if (e is JsonParseException
                    || e is JSONException
                    || e is ParseException) {
                ex = ResponeThrowable(e, ERROR.PARSE_ERROR)
                ex.msg = "解析异常"
                return ex
            } else if (e is ConnectException || e is UnknownHostException) {
                ex = ResponeThrowable(e, ERROR.NETWORD_ERROR)
                ex.msg = "无网络,请重试!"
                return ex
            } else if (e is javax.net.ssl.SSLHandshakeException) {
                ex = ResponeThrowable(e, ERROR.SSL_ERROR)
                ex.msg = "证书验证异常"
                return ex
            } else if (e is ConnectTimeoutException || e is java.net.SocketTimeoutException) {
                ex = ResponeThrowable(e, ERROR.TIMEOUT_ERROR)
                ex.msg = "连接超时"
                return ex
            } else {
                ex = ResponeThrowable(e, ERROR.UNKNOWN)
                ex.msg = "未知错误"
                return ex
            }
        }
    }
}
