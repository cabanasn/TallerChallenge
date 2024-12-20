package com.example.myapplication.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    response: Response? = null,
    onLogin: (String, String) -> Unit = { _, _ -> }
) {

    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Login"
        )
        TextField(
            modifier = modifier.fillMaxWidth(),
            value = user,
            onValueChange = { user = it },
            label = { Text("User") }
        )
        TextField(
            modifier = modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )
        Button(onClick = {
            onLogin(user, password)
        }) {
            Text("Login")
        }
        when(response) {
            Response.Failed -> Text("Login Failed")
            Response.Loading -> CircularProgressIndicator()
            Response.Success -> Text("Login Success")
            null -> {}
        }
    }


}



@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
    )
}