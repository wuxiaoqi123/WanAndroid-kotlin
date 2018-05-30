package com.welcome.home.playandroid.util

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil {
    companion object {

        fun isNetworkAvailable(context: Context): Boolean {
            val manager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = manager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable) {
                return true
            }
            return false
        }

    }
}