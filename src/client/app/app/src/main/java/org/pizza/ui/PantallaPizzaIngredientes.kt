package org.pizza.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.pizza.R
import org.pizza.data.viewmodel.UsuarioVM
import org.pizza.utilidades.Boton
import org.pizza.utilidades.IngredientePrecioCantidad
import org.pizza.utilidades.Toggle
import org.pizza.utilidades.BodyText


/**
 * Encapsula todos los elementos gráficos
 * de la pantalla de selección de ingredientes.
 *
 * @param navController NavController que nos permite navegar a otras pantallas de este contexto.
 * @param usuarioVM ViewModel con información sobre los usuarios.
 * */

// Porque se queja el IDE si no uso el padding values de la lambda final de scaffold
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

// Por algún motivo requiere features del experimental cuando Material3 se supone que ya era estable
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun PantallaPizzaIngredientes(navController: NavController, usuarioVM: UsuarioVM) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text("Selección de ingredientes") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("pantalla_pizza_principal") }) {
                        Icon(
                            Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "Menú"
                        )
                    }
                })
        }) {

        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.
                size(256.dp),
                painter = painterResource(id = R.drawable.pizzaingredients),
                contentDescription = "Imagen principal"
            )

            BodyText(value = "Selecciona los ingredientes")
            Divider(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = 10.dp, bottom = 10.dp),
                thickness = 2.dp
            )


            val listIngredients = listOf<String>("i1", "i2")

            for (ingredient in listIngredients) {
                Toggle(label = ingredient) {
                    if (it) {
                        val ingredientPrice = 0.5f
                        val ingredientAmount = 1

                        usuarioVM.usuariosState.setIngredientesElegido(
                            IngredientePrecioCantidad(ingredient, ingredientPrice, ingredientAmount)
                        )
                    } else {
                        usuarioVM.usuariosState.removeIngredienteElegido(ingredient)
                    }
                }
            }
            
            Boton(label = "Finaliza compra") {
                navController.navigate("pantalla_pizza_pago")
            }
        }
    }
}