package com.welcome.home.playandroid.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.welcome.home.playandroid.bean.ColumnList

class ColumnExpandableListViewAdapter(context: Context) : BaseExpandableListAdapter() {

    var mColumnLists: List<ColumnList>? = null
    var mContext: Context? = context

    init {
        mColumnLists = ArrayList()
    }

    fun setColumnLists(columnList: List<ColumnList>) {
        mColumnLists?.firstOrNull()
    }


    override fun getGroup(groupPosition: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

    override fun getChildrenCount(groupPosition: Int): Int {
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

    override fun getGroupCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}