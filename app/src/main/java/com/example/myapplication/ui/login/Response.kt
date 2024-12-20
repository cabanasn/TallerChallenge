package com.example.myapplication.ui.login

sealed class Response {
    data object Loading : Response()
    data object Success : Response()
    data object Failed : Response()
}