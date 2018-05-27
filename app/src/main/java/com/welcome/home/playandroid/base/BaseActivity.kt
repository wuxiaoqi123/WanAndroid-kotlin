package com.welcome.home.playandroid.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

abstract class BaseActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun initWindow(): Void

    protected abstract fun initData(): Void

    protected abstract fun initViews(): Void

    protected abstract fun initListener(): Void


    fun <T> bindToLife(): LifecycleTransformer<T> {
        return bindUntilEvent(ActivityEvent.DESTROY)
    }
}