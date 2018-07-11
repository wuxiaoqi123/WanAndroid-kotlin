package com.welcome.home.playandroid.net.callback

import com.welcome.home.playandroid.net.exception.ExceptionHandler
import com.welcome.home.playandroid.net.exception.ResponeThrowable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class RxObserver<T> : Observer<T> {

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        onFail(ExceptionHandler.handleException(e));
    }

    override fun onComplete() {
    }

    abstract fun onFail(e: ResponeThrowable)

    abstract fun onSuccess(t: T)
}