package br.com.estudosqia.cesmaccpa.ui.activitys

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.estudosqia.cesmaccpa.R
import br.com.estudosqia.cesmaccpa.model.GerenciadorDeContas

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        configAgradecimento()
        configButtonVoltarLogin()
    }

    private fun configAgradecimento() {
        val agradeciemento = findViewById<TextView>(R.id.finish_textView)
        agradeciemento.text = "${GerenciadorDeContas().user().uppercase()}, \n" +
                "agradecemos por sua participação!\n"
    }

    private fun configButtonVoltarLogin() {
        val buttonVoltarLogin = findViewById<Button>(R.id.finish_button_voltarLogin)
        buttonVoltarLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}