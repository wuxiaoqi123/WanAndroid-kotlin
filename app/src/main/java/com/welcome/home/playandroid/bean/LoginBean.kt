package com.welcome.home.playandroid.bean

data class LoginBean(
        val email: String,
        val icon: String,
        val id: Int,
        val password: String,
        val type: Int,
        val username: String,
        val collectIds: List<Any>
)