package com.welcome.home.playandroid.net.callback

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class RxObserver<T> : Observer<T> {

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {

    }

    override fun onComplete() {
    }

    abstract fun onFail()

    abstract fun onSuccess(t: T)
}