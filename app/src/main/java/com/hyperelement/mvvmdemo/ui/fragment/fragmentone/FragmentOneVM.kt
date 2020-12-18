package com.hyperelement.mvvmdemo.ui.fragment.fragmentone

import androidx.lifecycle.MutableLiveData
import com.hyperelement.mvvmdemo.data.datasources.local.EmployeeEntity
import com.hyperelement.mvvmdemo.data.datasources.model.generic.ContinentCountry
import com.hyperelement.mvvmdemo.data.repository.FragmentOneRepository
import com.hyperelement.mvvmdemo.utilities.RootViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception
import java.util.*
import kotlin.concurrent.schedule

private const val TAG = "FragmentOneViewModel"

class FragmentOneViewModel(
    private val mRepo: FragmentOneRepository
) : RootViewModel() {

    val mContinentCountryList = MutableLiveData<List<ContinentCountry>>()

    fun loadContinentCountry() {
        launch {
            try {
                withContext(Dispatchers.IO) {
                    val response = mRepo.getContinentCountry()
                    mContinentCountryList.postValue(response)
                }
            } catch (exception: Exception) {
                Timber.e("Error $exception")
            }
        }
    }

}