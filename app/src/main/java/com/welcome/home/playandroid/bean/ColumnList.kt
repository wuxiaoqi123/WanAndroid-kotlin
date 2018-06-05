package com.welcome.home.playandroid.bean

data class ColumnList(
        val courseId: Int,
        val id: Int,
        val name: String,
        val order: Int,
        val parentChapterId: Int,
        val visible: Int,
        val children: List<ChildrenBean>
)

data class ChildrenBean(
        val courseId: Int,
        val id: Int,
        val name: String,
        val order: Int,
        val parentChapterId: Int,
        val visible: Int,
        val children: List<Any>
)