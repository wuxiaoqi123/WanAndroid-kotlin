package com.welcome.home.playandroid.net.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.RuntimeException

class RetrofitClient(baseUrl: String, okHttpClient: OkHttpClient) {
    var mOkHttpClient: OkHttpClient? = okHttpClient
    var mBaseUrl: String? = baseUrl
    var mRetrofit: Retrofit? = null

    fun setBaseUrl(baseUrl: String): RetrofitClient {
        this.mBaseUrl = baseUrl
        return this
    }

    fun <T> build(service: Class<T>): T? {
        if (mBaseUrl == null) {
            throw RuntimeException("baseUrl is null!")
        }
        if (service == null) {
            throw RuntimeException("api Service is null!")
        }
        mRetrofit = Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return mRetrofit?.create(service)
    }
}