package com.welcome.home.playandroid.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

abstract class BaseActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        initWindow()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData();
        initViews();
        initListener();
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun initWindow()

    protected abstract fun initData()

    protected abstract fun initViews()

    protected abstract fun initListener()


    fun <T> bindToLife(): LifecycleTransformer<T> {
        return bindUntilEvent(ActivityEvent.DESTROY)
    }
}