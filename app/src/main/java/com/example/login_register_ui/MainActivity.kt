package com.example.login_register_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_register_ui.ui.theme.LoginRegisterUiTheme
import com.example.login_register_ui.view.LoginPage
import com.example.login_register_ui.view.Register

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginRegisterUiTheme {
                NavigatePage()
            }
        }
    }
}

@Composable
fun NavigatePage() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login_page",
        builder = {
            composable("login_page",
                content = {
                    LoginPage(navController = navController)
                })
            composable("register_page", content = { Register(navController = navController) })
        }
    )
}
