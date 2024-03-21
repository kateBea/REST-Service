package org.pizza.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.pizza.data.viewmodel.UsuarioVM

/**
 * Actividad principal para la selección y compra de pizzas.
 * */
class PizzaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Obtener los datos del usuario del intent,
            // Esta actividad se llamada de la LoginActivity si y sólo si se
            // ha iniciado sesión correctamente
            val usuario: String = intent.getStringExtra("Usuario") ?: "UserUnknown"
            val password: String = intent.getStringExtra("Password") ?: "PasswordUnknown"

            SelectPizza(UsuarioVM(), usuario, password)
        }
    }
}

/**
 * Composable principal para la selección de pizza.
 *
 * @param usuarioVM ViewModel de usuario para gestionar los datos del usuario.
 * @param user Nombre de usuario.
 * @param pass Contraseña del usuario.
 * */
@Composable
fun SelectPizza(usuarioVM: UsuarioVM, user: String, pass: String) {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            usuarioVM.setUsuarioActual(user, pass)
        }

        Log.d("DEBUG", "Datos del usuario: Usuario(user=${user}, pass=${pass}))")
    }

    NavHost(
        navController = navController,
        startDestination = "pantalla_pizza_principal"
    ) {
        composable("pantalla_pizza_principal") {
            PantallaPizzaPrincipal(navController, usuarioVM)
        }

        composable("pantalla_pizza_ingredientes") {
            PantallaPizzaIngredientes(navController, usuarioVM)
        }

        composable("pantalla_pizza_pago") {
            PantallaPizzaPago(navController, usuarioVM)
        }
    }
}