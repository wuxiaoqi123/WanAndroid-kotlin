package com.welcome.home.playandroid.activity

import android.net.Uri
import android.view.ViewGroup
import android.widget.ProgressBar
import com.tencent.smtt.sdk.ValueCallback
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.base.BaseActivity
import com.welcome.home.playandroid.bean.CollectArticleList
import com.welcome.home.playandroid.contract.CollectContract
import com.welcome.home.playandroid.presenter.CollectPresenter
import com.welcome.home.playandroid.util.W5WebView
import java.net.URL

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/07/25
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class BrowserActivity : BaseActivity(), CollectContract.View {

    companion object {
        val MSG_INIT_UI = 1
        val KEY_TITLE = "key_title"
        val KEY_QUTHOR = "key_author"
        val KEY_LINK = "key_link"
        val TAG = "BrowserActivity"
        val mHomeUrl = "http://apphtml5.qq.com/navi/index"
    }

    private var mWebView: W5WebView? = null
    private var mViewParent: ViewGroup? = null
    private var mPageLoadingProgressBar: ProgressBar? = null
    private var uploadFile: ValueCallback<Uri>? = null
    private var mIntentUrl: URL? = null
    private var isFirstLoad = true
    private var pressenterImp: CollectPresenter? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_browser
    }

    override fun initWindow() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initViews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun collectSuccess(collectArticleList: CollectArticleList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrMsg(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}