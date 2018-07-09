package com.welcome.home.playandroid.net.config

import android.content.Context
import android.util.Log
import okhttp3.Cache
import okhttp3.ConnectionPool
import java.io.File
import java.io.InputStream
import java.util.*
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
class NetWorkConfiguration(context: Context) {

    var isCache: Boolean = false
        private set
    var isDiskCache: Boolean = false
        private set
    var isMemoryCache: Boolean = false
        private set

    private var memoryCacheTime: Int = 0
    var diskCacheTime: Int = 0
        private set

    private val maxDiskCacheSize: Int

    var diskCache: Cache? = null
        private set

    var connectTimeOut: Int = 0
        private set

    var connectionPool: ConnectionPool? = null
        private set

    var certificates: Array<InputStream>? = null
        private set

    private val context: Context

    var baseUrl: String? = null
        private set

    init {
        this.isCache = false
        this.isDiskCache = false
        this.isMemoryCache = false
        this.memoryCacheTime = 60
        this.diskCacheTime = 60 * 60 * 24 * 28
        this.maxDiskCacheSize = 30 * 1024 * 1024
        this.context = context.applicationContext
        this.diskCache = Cache(File(this.context.cacheDir, "network"), maxDiskCacheSize.toLong())
        this.connectTimeOut = 10000
        this.connectionPool = ConnectionPool(50, 60, TimeUnit.SECONDS)
        certificates = null
        baseUrl = null
    }

    fun isCache(isCache: Boolean): NetWorkConfiguration {
        this.isCache = isCache
        return this
    }

    fun isDiskCache(diskcache: Boolean): NetWorkConfiguration {
        this.isDiskCache = diskcache
        return this
    }

    /**
     * 是否进行内存缓存
     *
     * @param memorycache
     * @return
     */
    fun isMemoryCache(memorycache: Boolean): NetWorkConfiguration {
        this.isMemoryCache = memorycache
        return this
    }

    /**
     * 设置内存缓存时间
     *
     * @param memorycachetime
     * @return
     */
    fun memoryCacheTime(memorycachetime: Int): NetWorkConfiguration {
        if (memorycachetime <= 0) {

            Log.e(TAG, " configure memoryCacheTime  exception!")
            return this
        }
        this.memoryCacheTime = memorycachetime
        return this
    }

    fun getmemoryCacheTime(): Int {
        return this.memoryCacheTime
    }

    /**
     * 设置本地缓存时间
     *
     * @param diskcahetime
     * @return
     */
    fun diskCacheTime(diskcahetime: Int): NetWorkConfiguration {
        if (diskcahetime <= 0) {
            Log.e(TAG, " configure diskCacheTime  exception!")
            return this
        }
        this.diskCacheTime = diskcahetime
        return this
    }

    /**
     * 设置本地缓存路径以及 缓存大小
     *
     * @param saveFile         本地路径
     * @param maxDiskCacheSize 大小
     * @return
     */
    fun diskCaChe(saveFile: File, maxDiskCacheSize: Int): NetWorkConfiguration {
        if (!saveFile.exists() && maxDiskCacheSize <= 0) {
            Log.e(TAG, " configure connectTimeout  exception!")
            return this
        }
        diskCache = Cache(saveFile, maxDiskCacheSize.toLong())
        return this
    }

    /**
     * 设置网络超时时间
     *
     * @param timeout
     * @return
     */
    fun connectTimeOut(timeout: Int): NetWorkConfiguration {
        if (connectTimeOut <= 0) {
            Log.e(TAG, " configure connectTimeout  exception!")
            return this
        }
        this.connectTimeOut = timeout
        return this
    }

    /**
     * 设置网络线程池
     *
     * @param connectionCount 线程个数
     * @param connectionTime  连接时间
     * @param unit            时间单位
     * @return
     */
    fun connectionPool(connectionCount: Int, connectionTime: Int, unit: TimeUnit): NetWorkConfiguration {
        /**
         * 线程池 线程个数和连接时间设置过小
         */
        if (connectionCount <= 0 && connectionTime <= 0) {
            Log.e(TAG, " configure connectionPool  exception!")
            return this
        }
        this.connectionPool = ConnectionPool(connectionCount, connectionTime.toLong(), unit)
        return this
    }

    /**
     * 设置Https客户端带证书访问
     *
     * @param certificates
     * @return
     */
    fun certificates(certificates: Array<InputStream>): NetWorkConfiguration {
        if (certificates != null) {
            this.certificates = certificates
        } else {
            Log.e(TAG, "no  certificates")
        }
        return this
    }

    /**
     * 设置网络BaseUrl地址
     *
     * @param url
     * @return
     */
    fun baseUrl(url: String?): NetWorkConfiguration {
        if (url != null) {
            this.baseUrl = url
        } else {
            Log.e(TAG, "NetWorkConfiguration no  baseUrl")
        }
        return this
    }

    override fun toString(): String {
        return "NetWorkConfiguration{" +
                "isCache=" + isCache +
                ", isDiskCache=" + isDiskCache +
                ", isMemoryCache=" + isMemoryCache +
                ", memoryCacheTime=" + memoryCacheTime +
                ", diskCacheTime=" + diskCacheTime +
                ", maxDiskCacheSize=" + maxDiskCacheSize +
                ", diskCache=" + diskCache +
                ", connectTimeout=" + connectTimeOut +
                ", connectionPool=" + connectionPool +
                ", certificates=" + Arrays.toString(certificates) +
                ", context=" + context +
                ", baseUrl='" + baseUrl + '\''.toString() +
                '}'.toString()
    }

    companion object {

        private val TAG = "play_android"
    }
}