package com.welcome.home.playandroid.bean

data class HomeList(
        val curPage: Int,
        val offset: Int,
        val over: Boolean,
        val pageCount: Int,
        val size: Int,
        val total: Int,
        val datas: List<HomeDataBean>
)

data class HomeDataBean(
        val appLink: String,
        val author: String,
        val chapterId: Int,
        val chapterName: String,
        val collect: Boolean,
        val courseId: Int,
        val desc: String,
        val envelopePic: String,
        val fresh: Boolean,
        val id: Int,
        val link: String,
        val niceDate: String,
        val origin: String,
        val projectLink: String,
        val publishTime: Long,
        val superChapterId: Int,
        val superChapterName: String,
        val title: String,
        val type: Int,
        val visible: Int,
        val zan: Int,
        val tags: List<TagsBean>
)

data class TagsBean(
        val name: String,
        val url: String
)