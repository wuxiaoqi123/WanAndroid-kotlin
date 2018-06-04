package com.welcome.home.playandroid.bean

data class CollectList(
        val curPage: Int,
        val offset: Int,
        val over: Boolean,
        val pageCount: Int,
        val size: Int,
        val total: Int,
        val datas: List<CollectArticleList>
)