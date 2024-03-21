package org.pizza.ui

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.pizza.utilidades.Boton
import org.pizza.utilidades.PasswordField
import org.pizza.utilidades.InputField
import org.pizza.utilidades.TextoBienvenida
import org.pizza.R


/**
 * Encapsula todos los elementos gráficos
 * de la pantalla de selección de registro.
 *
 * @param navController NavController que nos permite navegar a otras pantallas de este contexto.
 * @param usuarioVM ViewModel con información sobre los usuarios.
 * */

@Composable
fun PantallaRegistro(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        HeaderRegistro()
        BodyRegistro(navController)

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

        FooterRegistro(navController)
    }
}

/**
 * Contenedor de los elementos gráficos de la cabecera
 * de la pantalla de registro.
 * */
@Composable
fun HeaderRegistro() {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextoBienvenida(contenido = "Registro de usuario")
    }
}

/**
 * Contenedor de los elementos gráficos del cuerpo
 * de la pantalla de registro.
 *
 * @param navController NavController que nos permite navegar a otras pantallas de este contexto.
 * */
@Composable
fun BodyRegistro(navController: NavController) {

    val coroutineScope = rememberCoroutineScope()

    Column (
        modifier = Modifier
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        var wantRegister by rememberSaveable { mutableStateOf(false) }

        var nuevoUsuarioNombre by rememberSaveable { mutableStateOf("") }
        var nuevoUsuarioEmail by rememberSaveable { mutableStateOf("") }
        var nuevoUsuarioTelefono by rememberSaveable { mutableStateOf("") }
        var nuevoUsuarioPassword by rememberSaveable { mutableStateOf("") }

        InputField("Nombre de usuario",
            isError = wantRegister.and(nuevoUsuarioNombre.isEmpty())) { nuevoUsuarioNombre = it }
        InputField("Correo Electrónico",
            isError = wantRegister.and(nuevoUsuarioEmail.isEmpty())) { nuevoUsuarioEmail = it }
        InputField("Número de teléfono",
            isError = wantRegister.and(nuevoUsuarioTelefono.isEmpty())) { nuevoUsuarioTelefono = it }
        PasswordField (
            isError = wantRegister.and(nuevoUsuarioPassword.isEmpty())) { nuevoUsuarioPassword = it }

        Boton("Registrar", descripcion = "Dar de alta a un nuevo usuario") {

        }
    }
}

/**
 * Contenedor de los elementos gráficos del pie de página
 * de la pantalla de registro.
 *
 * @param navController NavController que nos permite navegar a otras pantallas de este contexto.
 * */
@Composable
fun FooterRegistro(navController: NavController) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(0.6f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "¿Ya tiene cuenta?", textAlign = TextAlign.Center)

            TextButton(
                onClick = { navController.navigate("pantalla_inicio") },
                colors = ButtonDefaults.textButtonColors(containerColor = Color(0.0f, 0.0f, 0.0f, 0.0f))
            ) {
                Text(text = "Iniciar seción", textAlign = TextAlign.Center)
            }

        }

        Boton("Iniciar con Meta", painterResource(id = R.drawable.logometa),descripcion = "Iniciar sesión con Meta")
        Boton("Iniciar con Google", painterResource(id = R.drawable.logogoogle),descripcion = "Iniciar sesión con Google")
    }
}