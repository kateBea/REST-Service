package org.pizza.data.viewmodel

import org.pizza.data.modelo.Cliente
import org.pizza.utilidades.IngredientePrecioCantidad


data class UsuarioState(
    var usuarioActual: Cliente? = null,
    var tipoMasa: String? = null,
    val precioMasa: Float = 5.0f, // Por ahora todas las masas tienen el mismo precio
    var ingredientesElegidos: MutableList<IngredientePrecioCantidad> = mutableListOf()
) {
    /**
     * Agrega un ingrediente a la lista de ingredientes elegidos si no existe ya en la lista.
     *
     * @param item El ingrediente con su precio y cantidad que se va a agregar.
     * */
    fun setIngredientesElegido(item: IngredientePrecioCantidad) {
        if (ingredientesElegidos.find { ing -> ing.nombreIngrediente.equals(item.nombreIngrediente) } == null) {
            ingredientesElegidos.add(item)
        }
    }

    /**
     * Elimina un ingrediente de la lista de ingredientes elegidos según su nombre.
     *
     * @param nombre El nombre del ingrediente que se va a eliminar de la lista.
     * */
    fun removeIngredienteElegido(nombre: String) {
        ingredientesElegidos.removeIf { ingrediente -> ingrediente.nombreIngrediente.equals(nombre) }
    }
}