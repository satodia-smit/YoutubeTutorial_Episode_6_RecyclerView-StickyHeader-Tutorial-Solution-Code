package com.hyperelement.mvvmdemo.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hyperelement.mvvmdemo.data.datasources.local.EmployeeEntity
import com.hyperelement.mvvmdemo.data.datasources.model.generic.ContinentCountry
import com.hyperelement.mvvmdemo.utilities.ExtraUtils
import java.lang.reflect.Type

//we can inject context or dao as per the necessary
class FragmentOneRepository(
    private val context: Context
) {

    suspend fun getContinentCountry(): List<ContinentCountry>{
        val mString = ExtraUtils.getJsonFromAssets(context, "Continent.json")
        val mContinentCountryListType: Type =
            object : TypeToken<ArrayList<ContinentCountry>>(){}.type

        return Gson().fromJson(mString, mContinentCountryListType)
    }
}