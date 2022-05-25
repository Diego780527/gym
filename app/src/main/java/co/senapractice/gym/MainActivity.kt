package co.senapractice.gym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        iniciarComponentes()
    }

    private fun iniciarComponentes(){

        val botonRegistro:Button=findViewById(R.id.btnRegistro)
        val botonEstadistica:Button=findViewById(R.id.btnEstadistica)
        val botonAyuda:Button=findViewById(R.id.btnAyuda)

        botonRegistro.setOnClickListener { onClick( 1)}
        botonEstadistica.setOnClickListener { onClick( 2)}
        botonAyuda.setOnClickListener { onClick( 3)}
    }

    private fun onClick(boton: Int){
        when(boton){
            1->startActivity(Intent(this,Registro::class.java))
            2->startActivity(Intent(this,Estadistica::class.java))
            3->startActivity(Intent(this,Ayuda::class.java))

        }
    }
}