package com.welcome.home.playandroid.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.welcome.home.playandroid.bean.CollectArticleList

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/07/03
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class CollectionListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    companion object {
        val TYPE_HEAD = 0x01
        val TYPE_1 = 0x02
    }

    private var mList: MutableList<CollectArticleList>? = null
    private var headView: View? = null
    private var mContext: Context? = null

    constructor(context: Context) {
        this.mContext = context
        mList = ArrayList()
    }

    fun setHomeList(homeList: MutableList<CollectArticleList>) {
        mList?.clear()
        mList?.addAll(homeList)
        notifyDataSetChanged()
    }

    fun addHomeList(homeList: MutableList<CollectArticleList>) {
        mList?.addAll(homeList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}