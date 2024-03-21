package org.pizza.data.modelo

/**
 * Interfaz que define métodos para acceder y manipular datos de usuarios en la base de datos.
 *
 * Esta interfaz utiliza anotaciones de Room para definir consultas SQL y operaciones CRUD
 * (Create, Read, Update, Delete) sobre la tabla de usuarios.
 * */
interface ClienteRepository {

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param us El objeto Usuario que se va a insertar.
     * */
    suspend fun insertar(us: Cliente)

    /**
     * Actualiza la información de un usuario existente en la base de datos.
     *
     * @param us El objeto Usuario con la información actualizada.
     * @return El número de filas actualizadas en la base de datos.
     * */
    suspend fun actualizar(us: Cliente): Int

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param us El objeto Usuario que se va a eliminar.
     * */
    suspend fun borrar(us: Cliente)

    /**
     * Obtiene un usuario de la base de datos basado en su nombre de usuario y contraseña.
     *
     * @param username El nombre de usuario del usuario.
     * @param password La contraseña del usuario.
     * @return El objeto Usuario correspondiente al nombre de usuario y contraseña proporcionados,
     *         o null si no se encuentra ningún usuario con esas credenciales.
     * */
    suspend fun obtenerUsuario(username: String, password: String): Cliente?

    /**
     * Obtiene todos los usuarios almacenados en la base de datos.
     *
     * @return Una lista de todos los usuarios almacenados en la base de datos.
     * */
    suspend fun obtenerTodo(): List<Cliente>
}