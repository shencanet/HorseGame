
fun main(args: Array<String>) {
    val lista = listOf("10", "11", "12")//lista
    val Conjunto = setOf(1, 7 , 11)// elemento sin valores repetidos
    val diccionario = mapOf(1 to "one", 7 to "seven")//pares compuestos una clave y un valor

    fun isLetter(c: Char): Boolean = c in 'a'..'z' || c in 'A'..'Z'

    for ((index, element) in lista.withIndex()) {
        println("$element")
        println("$index")
        println(isLetter('a'))  // Pass a Char, not a String
        
        //usar lista
       val resultadSuma =  lista.sum();

        //COLECCION
        val resultadoSumaconjunto = conjunto.sum()

        val nombres: LIst<String>

        val nombres = listOf("Juan", "Maria", "Luis")
        print("${nombres.last()}")

        val lista1 = lisOf("Argumentos ": args)
        print(lista)
        
        

        
        
    }
}
