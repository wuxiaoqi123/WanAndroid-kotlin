package com.welcome.home.playandroid.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.components.support.RxFragment

abstract class BaseFragment : RxFragment() {

    protected var rootView: View? = null
    protected var mContext: Context? = null

    private var isViewPrepared: Boolean = false
    private var hasFetchData: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = activity
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val parent: ViewGroup? = rootView?.parent as ViewGroup?
        parent?.removeView(rootView)
        if (getLayoutId() == 0) {
            throw RuntimeException("getLayoutId need to set up res")
        }
        if (rootView != null) {
            return rootView
        }
        rootView = inflater.inflate(getLayoutId(), container, false)
        initView(savedInstanceState)
        initListener()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepared = true
        lazyFetchDataIfPrepared()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyFetchDataIfPrepared()
        }
    }

    private fun lazyFetchDataIfPrepared() {
        if (userVisibleHint && !hasFetchData && isViewPrepared) {
            hasFetchData = true
            lazyFetchData()
        }
    }

    abstract fun lazyFetchData()

    abstract fun initListener()

    abstract fun initView(savedInstanceState: Bundle?)

    open fun <T> bindToLife(): LifecycleTransformer<T> {
        return bindUntilEvent(FragmentEvent.DESTROY)
    }
}