package com.welcome.home.playandroid.net.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody

class LogInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val proceed = chain.proceed(chain.request())
        val contentType = proceed.body()?.contentType()
        val content = proceed.body()?.string()
        val t1 = System.nanoTime()
        Log.i("NetWork", String.format("Sending rquest %s on %s%n%s", request.url(), chain.connection(), request.headers()))
        val t2 = System.nanoTime()
        Log.i("NetWork", String.format("Received response for %s in %.1fms%n%s", proceed.request().url(), (t2 - t1) / 1e6, proceed.headers()))
        Log.i("NetWork", "response body:$content")
        if (proceed.body() != null) {
            val body = ResponseBody.create(contentType, content)
            return proceed.newBuilder().body(body).build()
        }
        return proceed
    }
}