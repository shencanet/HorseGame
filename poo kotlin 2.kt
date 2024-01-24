class Usuario {
    var id: Int = 0
        get() = field // Ejemplo de getter personalizado

    var nombre: String = ""
        set(value) {
            validar(value, "Nombre")
            field = value
        }
    
    var direccion: String = ""
        set(value) {
            validar(value, "Dirección")
            field = value
        }

    constructor(id: Int, nombre: String, direccion: String) {
        this.id = id
        this.nombre = nombre
        this.direccion = direccion
    }

    private fun validar(valor: String, nombreCampo: String) {
        if (valor.isEmpty()) {
            throw IllegalArgumentException("El campo $nombreCampo no puede estar en blanco")
        }
    }
}

fun guardarUsuario(usuario: Usuario) {
    println("Usuario ${usuario.id} guardado")
}

fun main() {
    try {
        val usuario = Usuario(1, "Juan Perez", "Calle 123, Ciudad")
        guardarUsuario(usuario)
    } catch (ex: IllegalArgumentException) {
        println("Error de Datos: ${ex.message}")
    }
}
