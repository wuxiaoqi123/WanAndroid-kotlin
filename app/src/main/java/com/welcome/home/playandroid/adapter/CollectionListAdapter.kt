package com.welcome.home.playandroid.adapter

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.welcome.home.playandroid.R
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

    fun setHeadView(@LayoutRes id: Int): View {
        val headerView = FrameLayout(mContext)
        headView = LayoutInflater.from(mContext).inflate(id, headerView, false)
        notifyDataSetChanged()
        return headView!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_HEAD -> return HomeListItemViewHolder(headView)
            else -> return HomeListItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_list, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var _postion = position
        if (getStart() > 0 && position == 0) return;
        if (getStart() > 0) _postion -= 1
        if (holder is HomeListItemViewHolder) {
            holder.bindHomeListItem(mList!!.get(_postion))
        }
    }

    private fun getStart(): Int {
        if (headView == null)
            return 0
        else
            return 1
    }

    override fun getItemCount(): Int {
        if (mList == null)
            return 0
        else
            return mList!!.size + getStart()
    }

    override fun getItemViewType(position: Int): Int {
        if (getStart() > 0 && position == 0) {
            return TYPE_HEAD
        }
        return TYPE_1
    }

    class HomeListItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var titleTv: TextView? = null
        var authorTv: TextView? = null
        var nicedateTv: TextView? = null

        init {
            titleTv = itemView?.findViewById(R.id.item_home_list_title_tv)
            authorTv = itemView?.findViewById(R.id.item_home_list_author_tv)
            nicedateTv = itemView?.findViewById(R.id.item_home_list_nicedate_tv)
        }

        fun bindHomeListItem(homeList: CollectArticleList) {
            titleTv?.setText(homeList.title)
            authorTv?.setText(homeList.author)
            nicedateTv?.setText(homeList.niceDate)
        }
    }
}