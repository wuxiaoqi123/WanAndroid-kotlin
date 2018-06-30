package com.welcome.home.playandroid.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.welcome.home.playandroid.bean.ColumnList

class ColumnExpandableListViewAdapter(context: Context) : BaseExpandableListAdapter() {

    var mColumnLists: MutableList<ColumnList>? = null
    var mContext: Context? = context

    init {
        mColumnLists = ArrayList()
    }

    fun setColumnLists(columnList: MutableList<ColumnList>) {
        mColumnLists?.clear()
        mColumnLists?.addAll(columnList)
        notifyDataSetChanged()
    }

    fun addColumnLists(columnList: MutableList<ColumnList>) {
        mColumnLists?.addAll(columnList)
        notifyDataSetChanged()
    }


    override fun getGroup(groupPosition: Int): Int? {
        return mColumnLists?.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        if (mColumnLists == null) return 0
        return mColumnLists?.get(groupPosition)?.children?.size!!
    }

    override fun getGroupCount(): Int {
        return mColumnLists?.size!!
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasStableIds(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGroupId(groupPosition: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}