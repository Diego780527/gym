package co.senapractice.gym
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide


class splash : AppCompatActivity() {

    val DURACION:Long=3000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val logo = findViewById<ImageView>(R.id.imagensplash)
        Glide.with(this).load(R.drawable.splashm).into(logo)
        cambiarActivity()
    }
    private fun cambiarActivity() {
        Handler().postDelayed(Runnable{
            val iniciar = Intent(this,MainActivity::class.java)
            startActivity(iniciar)//inicio la actividad
        },DURACION)

    }






}