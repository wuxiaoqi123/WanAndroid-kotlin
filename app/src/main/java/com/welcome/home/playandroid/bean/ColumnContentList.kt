package com.welcome.home.playandroid.bean

data class ColumnContentList(
        val curPage: Int,
        val offset: Int,
        val over: Boolean,
        val pageCount: Int,
        val size: Int,
        val total: Int,
        val datas: List<DatasBean>
)

data class DatasBean(
        val apkLink: String,
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
        val tags: List<Any>
)