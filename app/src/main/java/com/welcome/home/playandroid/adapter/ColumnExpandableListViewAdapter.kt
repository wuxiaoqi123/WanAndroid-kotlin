package com.welcome.home.playandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.welcome.home.playandroid.R
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


    override fun getGroup(groupPosition: Int): ColumnList? {
        return mColumnLists?.get(groupPosition)
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        if (mColumnLists == null) return 0
        return mColumnLists?.get(groupPosition)?.children?.size ?: 0
    }

    override fun getGroupCount(): Int {
        return mColumnLists?.size ?: 0
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any? {
        return mColumnLists?.get(groupPosition)?.children?.get(childPosition)
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var recyclerview = convertView
        if (recyclerview == null) {
            recyclerview = LayoutInflater.from(mContext).inflate(R.layout.item_column, parent, false)
        }
        recyclerview?.findViewById<TextView>(R.id.column_tv)
                ?.setText(getGroup(groupPosition)?.name)
        return recyclerview!!
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var recyclerview = convertView
        if (recyclerview == null) {
            recyclerview = LayoutInflater.from(mContext).inflate(R.layout.item_column_column, parent, false);
        }
        recyclerview?.findViewById<TextView>(R.id.column_tv)
                ?.setText(getGroup(groupPosition)?.children?.get(childPosition)?.name)
        recyclerview?.setOnClickListener { v ->
            //TODO
        }
        return recyclerview!!
    }
}