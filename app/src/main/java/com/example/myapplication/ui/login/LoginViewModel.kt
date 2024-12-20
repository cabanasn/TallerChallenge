package com.example.myapplication.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val _response = MutableStateFlow<Response?>(null)
    val response = _response.asStateFlow()

    val repository: UserRepository by lazy {
        UserRepository()
    }

    fun login(user: String, password: String) {
        viewModelScope.launch {
            _response.value = Response.Loading
            try {
                val success = repository.login(user, password)
                if (success) {
                    _response.value = Response.Success
                } else {
                    _response.value = Response.Failed
                }
            } catch (ex: Exception) {
                _response.value = Response.Failed
            }
        }
    }

}