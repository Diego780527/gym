package co.senapractice.gym

class Cliente {
    var nombre: String=""
    var edad: Int=0
    var peso: Double=0.0
    var talla_altura: Double=0.0
    var tipo: String=""

    var IMC:Double=0.0

    override fun toString(): String {
        return "Cliente(nombre='$nombre', edad='$edad', peso='$peso', " +
                "talla_altura='$talla_altura', IMC='$IMC')"
    }
}