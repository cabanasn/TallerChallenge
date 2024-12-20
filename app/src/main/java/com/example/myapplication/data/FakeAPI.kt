package com.example.myapplication.data

import kotlinx.coroutines.delay

object FakeAPI {

    suspend fun login(user: String, password: String): Boolean {
        delay(2000)
        return (user == "user" && password == "pass")
    }

}