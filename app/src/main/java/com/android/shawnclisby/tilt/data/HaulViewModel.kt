package com.android.shawnclisby.tilt.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shawnclisby.tilt.data.models.Haul
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class HaulViewModel : ViewModel() {

    private val repo: HaulRepository = HaulRepository()

    private val _haulList: MutableLiveData<List<Haul>?> = MutableLiveData(null)
    val haulList: LiveData<List<Haul>?> = _haulList

    private val _detailHaul: MutableLiveData<Haul?> = MutableLiveData(null)
    val detailHaul: LiveData<Haul?> = _detailHaul

    init {
        fetchHaulData()
    }

    fun fetchHaulData() {
        viewModelScope.launch(IO) {
            _haulList.postValue(repo.fetchHauls())
        }
    }

    fun newHaulItem() {
        viewModelScope.launch(IO) {
            repo.newHaulItem()
            _haulList.postValue(repo.fetchHauls())
        }
    }

    fun onSelectedHaul(haul: Haul) {
        _detailHaul.value = haul
    }

}