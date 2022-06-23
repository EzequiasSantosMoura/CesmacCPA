package br.com.estudosqia.cesmaccpa.ui.activitys

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.estudosqia.cesmaccpa.R

@Suppress("DEPRECATION")
@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Criando a intenção de iniciar a outra activity (em determinado tempo)
        handler = Handler()
        handler.postDelayed({

            val intent = Intent(this, LoginActivity::class.java) //Indicando a intenção
            startActivity(intent) //Iniciando a intenção
            finish() //Finalizando a activity

        }, 1000) //Dalay de 1s para abrir a MainActivity
    }
}