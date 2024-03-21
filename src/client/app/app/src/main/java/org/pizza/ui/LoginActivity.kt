package org.pizza.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EntryPoint()
        }
    }
}

@Composable
fun EntryPoint() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "pantalla_inicio"
    ) {
        composable("pantalla_inicio") {
            PantallaInicio(navController)
        }

        composable("pantalla_registro") {
            PantallaRegistro(navController)
        }
    }
}