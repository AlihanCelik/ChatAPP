package com.alihan.messageapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alihan.messageapp.presentation.Signup.SignUpScreen
import com.alihan.messageapp.presentation.Signup.SignUpViewModel
import com.alihan.messageapp.presentation.login.LoginScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("home") }
                , onSignUpClick ={navController.navigate("signup")} )
        }
        composable("signup") {
            SignUpScreen(onSignUpSuccess = { navController.navigate("home") })
        }

    }
}