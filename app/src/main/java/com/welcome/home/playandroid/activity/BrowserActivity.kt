package com.welcome.home.playandroid.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.net.Uri
import android.os.Handler
import android.os.Message
import android.view.*
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
import com.tencent.smtt.sdk.*
import com.tencent.smtt.utils.TbsLog
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.base.BaseActivity
import com.welcome.home.playandroid.bean.CollectArticleList
import com.welcome.home.playandroid.contract.CollectContract
import com.welcome.home.playandroid.presenter.CollectPresenter
import com.welcome.home.playandroid.util.X5WebView
import kotlinx.android.synthetic.main.activity_browser.*
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
        val KEY_AUTHOR = "key_author"
        val KEY_LINK = "key_link"
        val TAG = "BrowserActivity"
        val mHomeUrl = "http://apphtml5.qq.com/navi/index"

        fun startActivity(activity: Context, title: String, author: String, link: String) {
            val intent = Intent(activity, BrowserActivity::class.java)
            intent.putExtra(KEY_TITLE, title)
            intent.putExtra(KEY_AUTHOR, author)
            intent.putExtra(KEY_LINK, link)
            intent.setData(Uri.parse(link))
            activity.startActivity(intent)
        }
    }

    private var mWebView: X5WebView? = null
    private var mViewParent: ViewGroup? = null
    private var mPageLoadingProgressBar: ProgressBar? = null
    private var uploadFile: ValueCallback<Uri>? = null
    private var mIntentUrl: URL? = null
    private var isFirstLoad = true
    private var pressenterImp: CollectPresenter? = null
    private val mTestHandler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message?) {
            when (msg!!.what) {
                MSG_INIT_UI -> init()
            }
            super.handleMessage(msg)
        }
    }

    override fun initWindow() {
        window.setFormat(PixelFormat.TRANSLUCENT)
        try {
            window.setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_browser
    }

    override fun initData() {
        val intent = getIntent()
        if (intent != null) {
            mIntentUrl = URL(intent.data.toString())
        }
    }

    override fun initViews() {
        val toolbar = activity_browser_toolbar
        mViewParent = webView1
        mTestHandler.sendEmptyMessageDelayed(MSG_INIT_UI, 10)
        val supportActionBar = getSupportActionBar()
        if (supportActionBar == null) {
            setSupportActionBar(toolbar)
            getSupportActionBar()?.setTitle("")
            getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        }
        pressenterImp = CollectPresenter(this)
    }

    override fun initListener() {
    }

    override fun onDestroy() {
        mTestHandler.removeCallbacksAndMessages(null)
        mWebView?.destroy()
        super.onDestroy()
    }

    private fun initProgressBar() {
        mPageLoadingProgressBar = progressBar1
        mPageLoadingProgressBar?.max = 100
        mPageLoadingProgressBar?.progressDrawable = resources.getDrawable(R.drawable.color_progressbar)
    }

    fun init() {
        mWebView = X5WebView(this, null)
        mViewParent?.addView(mWebView, FrameLayout.LayoutParams(-1, -1))
        initProgressBar()
        mWebView?.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(p0: WebView?, p1: String?): Boolean {
                return false
            }

            override fun onPageFinished(p0: WebView?, p1: String?) {
                super.onPageFinished(p0, p1)
                isFirstLoad = false
                mPageLoadingProgressBar?.visibility = View.GONE
            }
        }
        mWebView?.webChromeClient = object : WebChromeClient() {

            var myVideoView: View? = null
            var myNormalView: View? = null
            var callback: IX5WebChromeClient.CustomViewCallback? = null

            override fun onHideCustomView() {
                callback?.onCustomViewHidden()
                callback = null
                super.onHideCustomView()
                if (myVideoView != null) {
                    var viewGroup = myVideoView!!.parent as ViewGroup
                    viewGroup.removeView(myVideoView)
                    viewGroup.addView(myNormalView)
                }
            }

            override fun onProgressChanged(p0: WebView?, p1: Int) {
                super.onProgressChanged(p0, p1)
                if (isFirstLoad) {
                    if (mPageLoadingProgressBar?.visibility != View.VISIBLE) {
                        mPageLoadingProgressBar?.visibility = View.VISIBLE
                    }
                    mPageLoadingProgressBar?.setProgress(p1)
                }
            }
        }

        mWebView?.setDownloadListener(object : DownloadListener {
            override fun onDownloadStart(p0: String?, p1: String?, p2: String?, p3: String?, p4: Long) {
                TbsLog.d(TAG, "url: $p0")
                AlertDialog.Builder(this@BrowserActivity)
                        .setTitle("allow to download？")
                        .setPositiveButton("yes"
                        ) { dialog, which ->
                            Toast.makeText(
                                    this@BrowserActivity,
                                    "fake message: i'll download...",
                                    Toast.LENGTH_LONG).show()
                        }
                        .setNegativeButton("no"
                        ) { dialog, which ->
                            // TODO Auto-generated method stub
                            Toast.makeText(
                                    this@BrowserActivity,
                                    "fake message: refuse download...",
                                    Toast.LENGTH_SHORT).show()
                        }
                        .setOnCancelListener { dialog ->
                            // TODO Auto-generated method stub
                            Toast.makeText(
                                    this@BrowserActivity,
                                    "fake message: refuse download...",
                                    Toast.LENGTH_SHORT).show()
                        }.show()
            }
        })

        val webSetting = mWebView!!.settings
        webSetting.allowFileAccess = true
        webSetting.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        webSetting.setSupportZoom(true)
        webSetting.builtInZoomControls = true
        webSetting.useWideViewPort = true
        webSetting.setSupportMultipleWindows(false)
        webSetting.setAppCacheEnabled(true)
        webSetting.domStorageEnabled = true
        webSetting.javaScriptEnabled = true
        webSetting.setGeolocationEnabled(true)
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE)
        webSetting.setAppCachePath(getDir("appcache", 0).path)
        webSetting.databasePath = getDir("databases", 0).path
        webSetting.setGeolocationDatabasePath(this.getDir("geolocation", 0)
                .path)
        webSetting.pluginState = WebSettings.PluginState.ON_DEMAND
        val time = System.currentTimeMillis()
        if (mIntentUrl == null) {
            mWebView?.loadUrl(mHomeUrl)
        } else {
            mWebView?.loadUrl(mIntentUrl.toString())
        }
        TbsLog.d("time-cost", "cost time: " + (System.currentTimeMillis() - time))
        CookieSyncManager.createInstance(this)
        CookieSyncManager.getInstance().sync()

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView != null && mWebView!!.canGoBack()) {
                mWebView!!.goBack()
                return true
            } else
                return super.onKeyDown(keyCode, event)
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                0 -> if (null != uploadFile) {
                    val result = data?.data
                    uploadFile?.onReceiveValue(result)
                    uploadFile = null
                }
                else -> {
                }
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            if (null != uploadFile) {
                uploadFile?.onReceiveValue(null)
                uploadFile = null
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        if (intent == null || mWebView == null || intent.data == null)
            return
        mWebView?.loadUrl(intent.data!!.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_collect, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.menu_btn_colledc -> try {
                pressenterImp?.collectArticle(intent.getStringExtra(KEY_TITLE),
                        intent.getStringExtra(KEY_AUTHOR), intent.getStringExtra(KEY_LINK))
            } catch (e: Exception) {
                e.printStackTrace()
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun collectSuccess(collectArticleList: CollectArticleList) {
        Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show()
    }

    override fun showErrMsg(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}