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
import com.welcome.home.playandroid.bean.HomeDataBean
import com.welcome.home.playandroid.bean.HomeList

class HomeListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    companion object {
        val TYPE_HEAD = 0x01
        val TYPE_1 = 0x02
    }

    private var mList: MutableList<HomeDataBean>? = null
    private var headView: View? = null
    private var mContext: Context? = null

    constructor(context: Context) {
        this.mContext = context
        mList = ArrayList()
    }

    fun setHomeList(homeList: HomeList) {
        mList?.clear()
        mList?.addAll(homeList.datas)
        notifyDataSetChanged()
    }

    fun addHomeList(homeList: HomeList) {
        mList?.addAll(homeList.datas)
        notifyDataSetChanged()
    }

    fun setHeaderView(@LayoutRes id: Int): View {
        val headerview = FrameLayout(mContext)
        headView = LayoutInflater.from(mContext).inflate(id, headerview, false)
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
        var position = position
        if (getStart() > 0 && position == 0) return //头View不bind
        if (getStart() > 0) position -= 1//有头View position减1
        if (holder is HomeListItemViewHolder) {
            holder.bindHomeListItem(mList!!.get(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (getStart() > 0) {
            if (position == 0) {
                return TYPE_HEAD
            }
        }
        return TYPE_1
    }

    override fun getItemCount(): Int {
        if (mList == null) return 0
        return mList!!.size + getStart()
    }

    private fun getStart(): Int {
        return if (headView == null) 0 else 1
    }

    internal class HomeListItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var titleTv: TextView? = null

        var authorTv: TextView? = null

        var nicedateTv: TextView? = null

        init {
            titleTv = itemView?.findViewById(R.id.item_home_list_title_tv)
            authorTv = itemView?.findViewById(R.id.item_home_list_author_tv)
            nicedateTv = itemView?.findViewById(R.id.item_home_list_nicedate_tv)
        }

        fun bindHomeListItem(homeListDatasBean: HomeDataBean) {
            if (titleTv == null || authorTv == null || nicedateTv == null) return
            titleTv!!.setText(homeListDatasBean.title)
            authorTv!!.setText(homeListDatasBean.author)
            nicedateTv!!.setText(homeListDatasBean.niceDate)
            itemView.setOnClickListener { v ->
                //                BrowserActivity.startActivity(itemView.context, homeListDatasBean.getTitle(), homeListDatasBean.getAuthor(), homeListDatasBean.getLink())
            }
        }
    }
}