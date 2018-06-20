package com.welcome.home.playandroid.adapter

import android.net.Uri
import cn.bingoogolapple.bgabanner.BGABanner
import com.facebook.drawee.view.SimpleDraweeView
import com.welcome.home.playandroid.bean.BannerList

class HomeBannerAdapter : BGABanner.Adapter<SimpleDraweeView, BannerList> {
    override fun fillBannerItem(banner: BGABanner?, itemView: SimpleDraweeView?, model: BannerList?, position: Int) {
        itemView?.setImageURI(Uri.parse(model?.imagePath))
    }

}