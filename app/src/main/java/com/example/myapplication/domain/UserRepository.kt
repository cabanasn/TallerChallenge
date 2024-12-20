package com.example.myapplication.domain

import com.example.myapplication.data.FakeAPI

class UserRepository {

    suspend fun login (user: String, password: String): Boolean {
        return FakeAPI.login(user, password)
    }

}