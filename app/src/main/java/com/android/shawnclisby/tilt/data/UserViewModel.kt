package com.android.shawnclisby.tilt.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shawnclisby.tilt.data.models.User
import com.android.shawnclisby.tilt.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val userRepo = UserRepository()

    private var _user: MutableLiveData<User?> = MutableLiveData(null)
    val user: LiveData<User?> = _user

    init {
        viewModelScope.launch(IO) {
            _user.postValue(userRepo.fetchUser()[0])
        }
    }

    fun takeHaulJob(haulId:String) {
        val user = _user.value!!
        user.haulId = haulId
        _user.postValue(user)
    }
}