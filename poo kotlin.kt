class Usuario(val id: Int, val nombre: String, val direccion: String) {
    // Puedes agregar métodos adicionales o realizar otras operaciones dentro de la clase si es necesario
}

fun guardarUsuario(usuario: Usuario) {
    fun validar(valor: String, nombreCampo: String) {
        if (valor.isEmpty()) {
            throw IllegalArgumentException("El campo $nombreCampo no puede estar en blanco")
        }
    }

    validar(usuario.nombre, "Nombre")
    validar(usuario.direccion, "Dirección")

    println("Usuario ${usuario.id} guardado")
}

fun main() {
    try {
        guardarUsuario(Usuario(1, "Juan Perez", "Calle 123, Ciudad"))
    } catch (ex: IllegalArgumentException) {
        println("Error de Datos: ${ex.message}")
    }
}
