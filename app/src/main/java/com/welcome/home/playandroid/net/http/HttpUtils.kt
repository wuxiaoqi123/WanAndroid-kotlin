package com.welcome.home.playandroid.net.http

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.welcome.home.playandroid.net.cache.CookieManager
import com.welcome.home.playandroid.net.config.NetWorkConfiguration
import com.welcome.home.playandroid.net.interceptor.LogInterceptor
import com.welcome.home.playandroid.util.NetworkUtil
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/07/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class HttpUtils private constructor() {

    companion object {
        val TAG = "HttpUtils"

        fun getInstance(): HttpUtils {
            return Singleton.instance
        }
    }

    private var mOkHttpClient: OkHttpClient? = null
    private var configuration: NetWorkConfiguration? = null

    private var mContext: Context? = null
    internal val interceptor: Interceptor = Interceptor { chain ->
        var request = chain.request()
        /**
         * 断网后是否加载本地缓存数据
         *
         */
        /**
         * 断网后是否加载本地缓存数据
         *
         */
        if (!NetworkUtil.isNetworkAvailable(mContext!!) && configuration!!.isDiskCache) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build()
        } else if (configuration!!.isMemoryCache) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build()
        } else {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_NETWORK)
                    .build()
        }
        /**
         * 加载网络数据
         */
        /**
         * 加载网络数据
         *///            加载内存缓存数据
        val response = chain.proceed(request)
        //            有网进行内存缓存数据
        if (NetworkUtil.isNetworkAvailable(mContext!!) && configuration!!.isMemoryCache) {
            response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + configuration!!.getmemoryCacheTime())
                    .removeHeader("Pragma")
                    .build()
        } else {
            //              进行本地缓存数据
            if (configuration!!.isDiskCache) {
                response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + configuration!!.diskCacheTime)
                        .removeHeader("Pragma")
                        .build()
            }
        }
        response
    }

    fun init(context: Context) {
        this.mContext = context.applicationContext
        if (configuration == null) {
            configuration = NetWorkConfiguration(context)
        }
        if (configuration!!.isCache) {

            mOkHttpClient = OkHttpClient.Builder()
                    //                   网络缓存拦截器
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(interceptor)
                    //                    自定义网络Log显示
                    .addInterceptor(LogInterceptor())
                    .cache(configuration!!.diskCache)
                    .cookieJar(CookieManager())
                    .connectTimeout(configuration!!.connectTimeOut.toLong(), TimeUnit.SECONDS)
                    .connectionPool(configuration!!.connectionPool!!)
                    .retryOnConnectionFailure(true)
                    .build()
        } else {
            mOkHttpClient = OkHttpClient.Builder()
                    .addInterceptor(LogInterceptor())
                    .cookieJar(CookieManager())
                    .connectTimeout(configuration!!.connectTimeOut.toLong(), TimeUnit.SECONDS)
                    .connectionPool(configuration!!.connectionPool!!)
                    .retryOnConnectionFailure(true)
                    .build()
        }
    }

    fun init(context: Context, baseUrl: String) {
        init(context)
        configuration!!.baseUrl(baseUrl)
    }

    fun setLoadDiskCache(isCache: Boolean): HttpUtils {
        if (configuration == null) {
            configuration = NetWorkConfiguration(mContext!!)
        }
        configuration!!.isDiskCache(isCache)
        return this
    }

    fun setLoadMemoryCache(isCache: Boolean): HttpUtils {
        if (configuration == null) {
            configuration = NetWorkConfiguration(mContext!!)
        }
        configuration!!.isMemoryCache(isCache)
        return this
    }

    /**
     * 设置网络配置参数
     *
     * @param configuration
     */
    fun setConFiguration(configuration: NetWorkConfiguration?) {
        var configuration = configuration
        if (configuration == null) {
            throw IllegalArgumentException("ImageLoader configuration can not be initialized with null")
        } else {
            if (configuration == null) {
                Log.d(TAG, "Initialize NetWorkConfiguration with configuration")
                configuration = configuration
            } else {
                Log.e(TAG, "Try to initialize NetWorkConfiguration which had already been initialized before. To re-init NetWorkConfiguration with new configuration ")
            }
        }
        if (configuration != null) {
            Log.i(TAG, "ConFiguration" + configuration.toString())
        }
    }

    fun getRetrofitClient(): RetrofitClient {
        return RetrofitClient(configuration!!.baseUrl!!, mOkHttpClient!!)
    }

    object Singleton {
        @SuppressLint("StaticFieldLeak")
        internal var instance = HttpUtils()
    }
}