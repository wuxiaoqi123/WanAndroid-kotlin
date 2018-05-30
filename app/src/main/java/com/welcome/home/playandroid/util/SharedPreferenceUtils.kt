package com.welcome.home.playandroid.util

import android.content.Context
import android.content.SharedPreferences
import com.welcome.home.playandroid.app.PlayAndroidApplication

class SharedPreferenceUtils {
    companion object {
        val FILENAME = "config"

        fun getContext(): Context {
            return PlayAndroidApplication.appContext
        }

        fun getSharedPreferences(): SharedPreferences {
            return getContext().getSharedPreferences(FILENAME, Context.MODE_PRIVATE)
        }

        fun getBooleanData(key: String, value: Boolean): Boolean {
            return getSharedPreferences().getBoolean(key, value)
        }

        fun setBooleanData(key: String, value: Boolean) {
            getSharedPreferences().edit().putBoolean(key, value).apply()
        }

        fun getStringData(key: String, value: String): String {
            return getSharedPreferences().getString(key, value)
        }

        fun setStringData(key: String, value: String) {
            getSharedPreferences().edit().putString(key, value).apply()
        }

        fun getIntData(key: String, value: Int): Int {
            return getSharedPreferences().getInt(key, value)
        }

        fun setIntData(key: String, value: Int) {
            getSharedPreferences().edit().putInt(key, value).apply()
        }

        fun getLongData(key: String, value: Long): Long {
            return getSharedPreferences().getLong(key, value)
        }

        fun setLongData(key: String, value: Long) {
            getSharedPreferences().edit().putLong(key, value).apply()
        }

        fun getFloatData(key: String, value: Float): Float {
            return getSharedPreferences().getFloat(key, value)
        }

        fun setFloatData(key: String, value: Float) {
            getSharedPreferences().edit().putFloat(key, value).apply()
        }

        fun clear() {
            getSharedPreferences().edit().clear().apply()
        }
    }
}