package com.welcome.home.playandroid.activity

import android.content.Context
import android.content.Intent
import com.welcome.home.playandroid.R
import com.welcome.home.playandroid.base.BaseActivity
import com.welcome.home.playandroid.bean.ColumnContentList
import com.welcome.home.playandroid.contract.ColumnContentContract

/**
 * <pre>
 *     author : 0
 *     e-mail : 1321972760@qq.com
 *     time   : 2018/07/31
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ColumnContentActivity : BaseActivity(), ColumnContentContract.View {

    companion object {
        val KEY_CID = "key_cid"

        fun startActivity(activity: Context, cid: Int) {
            val intent = Intent(activity, ColumnContentActivity::class.java)
            intent.putExtra(KEY_CID, cid)
            activity.startActivity(intent)
        }
    }

    private var c_id = 0
    private var page = 0

    override fun initWindow() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_column_content
    }

    override fun initData() {
        c_id = intent.getIntExtra(KEY_CID, 0)
    }

    override fun initViews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setColumnContent(columnContentList: ColumnContentList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addColumnContent(columnContentList: ColumnContentList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrMsg(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}