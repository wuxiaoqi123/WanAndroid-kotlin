package com.welcome.home.playandroid.net.api

import com.welcome.home.playandroid.bean.*
import com.welcome.home.playandroid.net.response.HttpResponse
import io.reactivex.Observable
import retrofit2.http.*

interface WanAndroidApi {

    @GET("/article/list/{page}/json")
    fun getHomeList(@Path("page") page: Int): Observable<HttpResponse<HomeList>>

    @GET("/tree/json")
    fun getColumnList(): Observable<HttpResponse<List<ColumnList>>>

    @GET("/article/list/{page}/json")
    fun getColumnContentList(@Path("page") page: Int, @Query("cid") c_id: Int): Observable<HttpResponse<ColumnContentList>>

    @GET("/banner/json")
    fun getBannerList(): Observable<HttpResponse<List<BannerList>>>

    @FormUrlEncoded
    @POST("/user/register")
    fun register(@Field("username") username: String, @Field("password") password: String, @Field("repassword") repassword: String): Observable<HttpResponse<LoginBean>>

    @FormUrlEncoded
    @POST("/user/login")
    fun login(@Field("username") username: String, @Field("password") password: String): Observable<HttpResponse<LoginBean>>

    @GET("/lg/collect/list/0/json")
    fun getCollectList(): Observable<HttpResponse<CollectList>>

    @FormUrlEncoded
    @POST("/lg/collect/add/json")
    fun collectArticle(@Field("title") title: String, @Field("author") author: String, @Field("link") link: String): Observable<HttpResponse<CollectArticleList>>
}