package com.welcome.home.playandroid.net.cache

import com.welcome.home.playandroid.app.PlayAndroidApplication

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class CookieManager : CookieJar {
    private val cookieStore = PersistentCookieStore(PlayAndroidApplication.appContext)

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        if (cookies.size > 0) {
            for (item in cookies) {
                cookieStore.add(url, item)
            }
        }
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        val cookies = cookieStore.get(url)
        return cookies
    }
}
