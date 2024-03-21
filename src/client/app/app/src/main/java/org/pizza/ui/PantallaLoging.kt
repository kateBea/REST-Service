package org.pizza.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.pizza.utilidades.Boton
import org.pizza.utilidades.PasswordField
import org.pizza.utilidades.InputField
import org.pizza.utilidades.SmallTextError
import org.pizza.utilidades.TextoBienvenida
import org.pizza.R

/**
 * Encapsula todos los elementos gráficos
 * de la pantalla de inicio de sesión.
 *
 * @param navController NavController que nos permite navegar a otras pantallas de este contexto.
 * @param usuarioVM ViewModel con información sobre los usuarios.
 * */
@Composable
fun PantallaInicio(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        // Cabecera
        Header()

        // Cuerpo
        Body()

        Separacion()

        // Pie
        Footer(navController)
    }
}

/**
 * Helper para separar el cuerpo del pie de página de esta
 * pantalla.
 * */
@Composable
fun Separacion() {
    Row (
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(modifier = Modifier
            .fillMaxWidth(0.2f), thickness = 2.dp)

        Text(text = "O bien")

        Divider(modifier = Modifier
            .fillMaxWidth(0.2f), thickness = 2.dp)
    }
}

/**
 * Encapsula todos los elementos gráficos de la cabecera
 * de la pantalla de Inicio de sesión.
 * */
@Composable
fun Header() {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.fillMaxSize(0.2f),
            painter = painterResource(id = R.drawable.pizza),
            contentDescription = "Logo loggin screen")
        TextoBienvenida(contenido = "Login")
        TextoBienvenida(contenido = "Bienvenid@ de nuevo")
    }
}

/**
 * Encapsula todos los elementos gráficos del cuerpo
 * de la pantalla de Inicio de sesión.
 *
 * @param usuarioVM ViewModel con información sobre los usuarios.
 * */
@Composable
fun Body() {
    val coroutineScope = rememberCoroutineScope()

    Column (
        modifier = Modifier
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        var username = ""
        var password = ""
        var credencialesIncorrectos by rememberSaveable { mutableStateOf(false) }

        InputField("Nombre de usuario", isError = credencialesIncorrectos) { username = it }
        PasswordField (isError = credencialesIncorrectos)  { password = it }

        val currentContext = LocalContext.current

        Boton("Iniciar sesión", descripcion = "Iniciar sesión") {

        }

        if (credencialesIncorrectos) {
            SmallTextError(error = "No existe usuario con los credenciales")
        }
    }
}

/**
 * Encapsula todos los elementos gráficos del pie
 * de la pantalla de Inicio de sesión.
 *
 * @param navController NavController que nos permite navegar a otras pantallas.
 * */
@Composable
fun Footer(navController: NavController) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(0.6f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "¿No tiene cuenta?", textAlign = TextAlign.Center)

            TextButton(
                onClick = { navController.navigate("pantalla_registro") },
                colors = ButtonDefaults.textButtonColors(containerColor = Color(0.0f, 0.0f, 0.0f, 0.0f))
            ) {
                Text(text = "Registrar", textAlign = TextAlign.Center)
            }

        }

        Boton("Iniciar con Meta", painterResource(id = R.drawable.logometa),descripcion = "Iniciar sesión con Meta")
        Boton("Iniciar con Google", painterResource(id = R.drawable.logogoogle),descripcion = "Iniciar sesión con Google")
    }
}