package com.hyperelement.mvvmdemo.ui.fragment.fragmentone.vh

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hyperelement.mvvmdemo.R
import com.hyperelement.mvvmdemo.data.datasources.model.generic.Country
import com.hyperelement.mvvmdemo.databinding.ItemStickyHeaderChildBinding
import com.hyperelement.mvvmdemo.utilities.ext.inflate
import smartadapter.viewholder.SmartViewHolder

class StickyHeaderChildVH(parentView: ViewGroup) : SmartViewHolder<Country>(
    parentView.inflate<ItemStickyHeaderChildBinding>(R.layout.item_sticky_header_child).root
) {
    override fun bind(item: Country) {
        val binding = DataBindingUtil.getBinding<ItemStickyHeaderChildBinding>(itemView)
        binding?.dataItem = item
    }

}