package co.senapractice.gym


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Estadistica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadistica)

        val campoTextoClientes: TextView = findViewById(R.id.mensaje_1)
        val campoTextoAnorexia: TextView = findViewById(R.id.textanorexia)
        val campoTextoDelgadez: TextView = findViewById(R.id.textDelgadez)
        val campoTextoNormal: TextView = findViewById(R.id.textnormal)
        val campoTextoObesidad1: TextView = findViewById(R.id.textObesidad1)
        val campoTextoObesidad2: TextView = findViewById(R.id.textobesidad2)
        val campoTextoObesidad3: TextView = findViewById(R.id.textobesidad3)
        val campoTextoObsesidadMorbida: TextView = findViewById(R.id.textobesidadMorbida)



        val bundleData: Bundle? = this.intent.extras

        if (bundleData != null) {
            campoTextoClientes.text = bundleData.getString("lista_Clientes")

            val procesados = bundleData.getIntArray("procesados")
            campoTextoAnorexia.text = procesados?.get(0).toString()
            campoTextoDelgadez.text = procesados?.get(1).toString()
            campoTextoNormal.text = procesados?.get(2).toString()
            campoTextoObesidad1.text = procesados?.get(3).toString()
            campoTextoObesidad2.text = procesados?.get(4).toString()
            campoTextoObesidad3.text = procesados?.get(5).toString()
            campoTextoObsesidadMorbida.text = procesados?.get(6).toString()


        }
        val btnAtras = findViewById<Button>(R.id.btnAtras1)
        btnAtras.setOnClickListener { onAtrasClick() }


    }
    fun onAtrasClick() {
        val iniciar = Intent(this,MainActivity::class.java)
        startActivity(iniciar)//inicio la actividad
    }
 }
