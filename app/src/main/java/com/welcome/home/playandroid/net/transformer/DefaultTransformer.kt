package com.welcome.home.playandroid.net.transformer

import com.welcome.home.playandroid.net.response.HttpResponse
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DefaultTransformer<T> : ObservableTransformer<HttpResponse<T>, T> {
    override fun apply(upstream: Observable<HttpResponse<T>>): ObservableSource<T> {
        return upstream.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .compose(ErrorTransformer.getInstance())
                .observeOn(AndroidSchedulers.mainThread())
    }
}