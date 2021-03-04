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

    init {
        fetchHaulData()
    }

    fun fetchHaulData() {
        viewModelScope.launch(IO) {
            _haulList.postValue(repo.fetchHauls())
        }
    }

}