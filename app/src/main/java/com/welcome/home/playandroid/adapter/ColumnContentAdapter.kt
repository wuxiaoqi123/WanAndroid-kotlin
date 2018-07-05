package com.welcome.home.playandroid.adapter

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.FrameLayout
import android.widget.TextView
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.bean.ColumnContentList
import com.welcome.home.playandroid.bean.DatasBean

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/07/05
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ColumnContentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    companion object {
        val TYPE_HEAD = 0x01
        val TYPE_1 = 0x02
    }

    private var mList: MutableList<DatasBean>? = null
    private var headView: View? = null
    private var mContext: Context? = null

    constructor(context: Context) {
        this.mContext = context
        mList = ArrayList()
    }

    fun setHomeList(homeList: ColumnContentList) {
        mList?.clear()
        mList?.addAll(homeList.datas)
        notifyDataSetChanged()
    }

    fun addHomeList(homelist: ColumnContentList) {
        mList?.addAll(homelist.datas)
        notifyDataSetChanged()
    }

    fun setHeaderView(@LayoutRes id: Int): View {
        var headerView = FrameLayout(mContext)
        headerView = LayoutInflater.from(mContext).inflate(id, headerView, false) as FrameLayout
        notifyDataSetChanged()
        return headerView!!
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_HEAD -> return HomeListItemViewHolder(headView)
            else -> return HomeListItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_list, parent, false))
        }
    }

    override fun getItemCount(): Int {
        if (mList == null) return 0
        return mList!!.size + getStart()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var _position = position
        if (getStart() > 0 && position == 0) return //头View不bind
        if (getStart() > 0) _position -= 1//有头View position减1
        if (holder is HomeListItemViewHolder) {
            holder.bindHomeListItem(mList!!.get(_position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (getStart() > 0)
            if (position == 0)
                return TYPE_HEAD
        return TYPE_1
    }

    private fun getStart(): Int {
        if (headView == null)
            return 0
        return 1
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

        fun bindHomeListItem(homeListDataBean: DatasBean) {
            titleTv?.setText(homeListDataBean.title)
            authorTv?.setText(homeListDataBean.author)
            nicedateTv?.setText(homeListDataBean.niceDate)
            itemView.animate().scaleX(0.9f).scaleY(0.7f).alpha(0.8f).setDuration(0).start()
            itemView.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(350).setInterpolator(OvershootInterpolator(0.8f)).start()
            itemView.setOnClickListener { }
        }
    }
}