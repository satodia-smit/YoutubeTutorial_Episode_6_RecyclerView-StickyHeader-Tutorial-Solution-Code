package com.hyperelement.mvvmdemo.ui.fragment.fragmentone

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import com.hyperelement.mvvmdemo.R
import com.hyperelement.mvvmdemo.arch.BaseFragment
import com.hyperelement.mvvmdemo.data.datasources.local.EmployeeEntity
import com.hyperelement.mvvmdemo.data.datasources.model.generic.Continent
import com.hyperelement.mvvmdemo.data.datasources.model.generic.Country
import com.hyperelement.mvvmdemo.databinding.FragmentOneBinding
import com.hyperelement.mvvmdemo.ui.fragment.fragmentone.vh.StickyHeaderChildVH
import com.hyperelement.mvvmdemo.ui.fragment.fragmentone.vh.StickyHeaderParentVH
import com.hyperelement.mvvmdemo.utilities.ExtraUtils
import kotlinx.android.synthetic.main.fragment_one.*
import smartadapter.SmartEndlessScrollRecyclerAdapter
import smartadapter.SmartRecyclerAdapter
import smartadapter.stickyheader.StickyHeaderItemDecorationExtension
import timber.log.Timber

class FragmentOne :
    BaseFragment<FragmentOneViewModel>(R.layout.fragment_one, FragmentOneViewModel::class) {

    private lateinit var adapter: SmartRecyclerAdapter

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getSpecificBinding<FragmentOneBinding>()?.viewModel = viewModel

        adapter = SmartRecyclerAdapter.empty()
            .map(Continent::class, StickyHeaderParentVH::class)
            .map(Country::class,StickyHeaderChildVH::class)
            .add(StickyHeaderItemDecorationExtension(
                headerItemType = Continent::class
            ))
            .into(rvEmployee)

        viewModel.loadContinentCountry()

        viewModel.mContinentCountryList.observe(viewLifecycleOwner, Observer {
            val mArray = arrayListOf<Any>()
            var mOldContinent = ""
            for (continent in it.sortedWith(compareBy({ it.continent }))) {
                if (mOldContinent != continent.continent){
                    mArray.add(Continent(continent.continent))
                    mOldContinent = continent.continent
                }
                mArray.add(Country(continent.name))
            }
            adapter.addItems(mArray.toMutableList())
        })

    }
}