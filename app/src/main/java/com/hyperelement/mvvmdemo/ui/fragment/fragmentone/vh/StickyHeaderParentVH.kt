package com.hyperelement.mvvmdemo.ui.fragment.fragmentone.vh

import android.view.ViewGroup
import android.widget.TextView
import com.hyperelement.mvvmdemo.R
import com.hyperelement.mvvmdemo.data.datasources.model.generic.Continent
import smartadapter.viewholder.SmartViewHolder

class StickyHeaderParentVH(parentview: ViewGroup) :
    SmartViewHolder<Continent>(parentview, R.layout.item_sticky_header_parent) {

    private val mcontinentHeaderView:TextView = itemView.findViewById(R.id.txtContinentHeader)
    override fun bind(item: Continent) {
        mcontinentHeaderView.text = item.mContinentName
    }
}