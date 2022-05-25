package co.senapractice.gym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Registro : AppCompatActivity() {

    var campoNombre:EditText?=null
    var campoEdad:EditText?=null
    var campoPeso:EditText?=null
    var campoAltura_Talla:EditText?=null
    var operaciones: Operaciones?=null

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        //Se instancia la clase operaciones
        operaciones= Operaciones()
        campoNombre=findViewById(R.id.editTextTextNombre)
        campoEdad=findViewById(R.id.editTextEdad)
        campoPeso=findViewById(R.id.editTextTextPeso)
        campoAltura_Talla=findViewById(R.id.editTextTextAltura_talla)

        var btnCalcular:Button=findViewById(R.id.btnRegistro)
        btnCalcular.setOnClickListener { registrarCliente() }

        var btnVerEstadistica: Button=findViewById(R.id.btn_VerEstadistica)
        btnVerEstadistica.setOnClickListener { cargarEstadistica() }


    }

    private fun registrarCliente() {
        //Se instancia la clase Clientes y se mapean los elementos del formulario
    val clie:Cliente= Cliente()
        clie.nombre=campoNombre?.text.toString()
        clie.edad=campoEdad?.text.toString().toInt()
        clie.peso=campoPeso?.text.toString().toDouble()
        clie.talla_altura=campoAltura_Talla?.text.toString().toDouble()
        clie.IMC= Operaciones!!.calcularIMC(clie)
        clie.tipo=Operaciones!!.resultadotipo(clie)

        Operaciones.registrarCliente(clie)
        Operaciones.imprimirListaCliente()
        cargarEstadistica()



        if (campoNombre?.text?.length == 0) {
           // El nombre está vacío
            return
        }
        if (clie.edad < 0) {
            // el valor es negativo
            return
        }
        if (clie.peso < 0) {
             //el valor es negativo
            return
        }
        if (clie.talla_altura < 0) {
             //el valor es negativo
            return
        }


    }


    private fun cargarEstadistica() {
        var listaclientes: ArrayList<Cliente> = Operaciones!!.devolverLista()
        var mensaje_estadisticas: String = formatearLista(listaclientes)
        var procesados: IntArray = Operaciones!!.cantidadProcesados()

        val intent = Intent(this, Estadistica::class.java)
        val miBundle: Bundle = Bundle()
        miBundle.putString("lista_Clientes", mensaje_estadisticas)
        miBundle.putIntArray("procesados", procesados)
        intent.putExtras(miBundle)
        startActivity(intent)
}
    private fun formatearLista(listaClientes: ArrayList<Cliente>): String {
        var mensaje = ""

        for (cliente in listaClientes){
            mensaje += "Nombre: ${cliente.nombre}\n"
            mensaje += "Edad: ${cliente.edad}\n"
            mensaje += "Peso: ${cliente.peso}\n"
            mensaje += "Talla: ${cliente.talla_altura}\n"
            mensaje += "IMC: ${cliente.IMC}\n\n\n"
        }
        return mensaje
   }
}
