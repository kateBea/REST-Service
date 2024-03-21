package org.pizza.data.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.pizza.data.modelo.Cliente
import kotlinx.coroutines.launch


class UsuarioVM() : ViewModel() {

    var usuariosState by mutableStateOf(UsuarioState())
        private set


    fun setUsuarioActual(username: String, password: String) = viewModelScope.launch {
    }

    fun insertar(usuario: Cliente) = viewModelScope.launch {
    }


    fun actualizar(usuario: Cliente) = viewModelScope.launch {

    }


    fun borrar(usuario: Cliente) = viewModelScope.launch {
    }
}
