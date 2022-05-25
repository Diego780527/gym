package co.senapractice.gym

class Operaciones {
    companion object {
        val listaCliente: ArrayList<Cliente> =arrayListOf<Cliente>()
        var contAnorexia: Int = 0
        var contDelgadez: Int = 0
        var contNormal: Int = 0
        var contObesidad1: Int = 0
        var contObesidad2: Int = 0
        var contObesidad3: Int = 0
        var contObesidad_morbida: Int = 0
        var contProcesados: Int =0


        fun registrarCliente(cliente: Cliente){
            this.listaCliente.add(cliente)
        }

        fun imprimirListaCliente(){
            for(clie in listaCliente){
                println(clie)
            }
        }

        fun calcularIMC(clie: Cliente): Double {
            var IMC= clie.peso /(clie.talla_altura * clie.talla_altura)
            return IMC
        }

        fun resultadotipo(clie: Cliente): String{
           var mensajeLocal = ""

            if (clie.IMC <18 ) {
                mensajeLocal = "Presenta Anorexia"
                contAnorexia++
            } else if (clie.IMC in 18.1..20.0) {
                mensajeLocal = "Delgadez"
                contDelgadez++
            } else if (clie.IMC in 20.1..27.0) {
                mensajeLocal = "Normal"
                contNormal++
            } else if (clie.IMC in 27.1..30.0) {
                mensajeLocal = "Obesidad1"
                contObesidad1++
            } else if (clie.IMC in 30.1..35.0) {
                mensajeLocal = "Obesidad2"
                contObesidad2++
            } else if (clie.IMC in 35.1..40.0) {
                mensajeLocal = "Obesidad3"
                contObesidad3++
            } else {
                mensajeLocal = "Obesidad Morbida"
                contObesidad_morbida++
            }
            contProcesados += 1
            return mensajeLocal
        }

        fun cantidadProcesados(): IntArray {
           return arrayOf(
               contProcesados, contAnorexia ,contDelgadez, contNormal, contObesidad1,
              contObesidad2, contObesidad3, contObesidad_morbida
            ).toIntArray()
        }

        fun devolverLista(): ArrayList<Cliente>{
            return this.listaCliente
        }
     }
    }


