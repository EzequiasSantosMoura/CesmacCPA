package br.com.estudosqia.cesmaccpa.ui.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.estudosqia.cesmaccpa.R
import br.com.estudosqia.cesmaccpa.model.GerenciadorDeContas

class LoginActivity : AppCompatActivity(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configButtonEntrar()
        configButtonRegistrar()
    }

    //Tudo sobre o botão entrar
    private fun configButtonEntrar() {
        //Iniciando o Button
        val entrar = findViewById<Button>(R.id.login_button_entrar)

        //Configurando o Button
        entrar.setOnClickListener {

            val user = configEntradaUser()
            val password = configEntradaPassword()

            if (!verificaLogin(user, password)) {
                Toast.makeText(this, "Senha e/ou usuário incorretos", Toast.LENGTH_SHORT).show()
            } else chamaQuestaoActivity()
        }
    }
    private fun verificaLogin(user: String, password: Int): Boolean {
        return GerenciadorDeContas().entrar(user = user, password = password)
    }
    private fun configEntradaUser(): String {
        //Iniciando o Edittext
        val campoLoginUser = findViewById<EditText>(R.id.login_input_user)
        return campoLoginUser.text.toString()
    }
    private fun configEntradaPassword(): Int {
        //Iniciando o Edittext
        val campoLoginPassword = findViewById<EditText>(R.id.login_input_password)
        val loginPassword = campoLoginPassword.text.toString()
        return if (loginPassword.isBlank()) {
            Int.MAX_VALUE
        } else loginPassword.toInt()
    }

    private fun chamaQuestaoActivity() {
        //Intenção: iniciar outra Activity
        val intent = Intent(this, MainActivity::class.java)
        //Iniciando a intenção
        startActivity(intent)
    }

    private fun configButtonRegistrar() {
        //Iniciando o Button
        val registrar = findViewById<Button>(R.id.login_button_registrar)
        //Configurando o FloatingActionButton
        registrar.setOnClickListener {
            chamaRegisterActivity()
        }
    }
    private fun chamaRegisterActivity() {
        //Intenção: iniciar outra Activity
        val intent = Intent(this, RegisterActivity::class.java)
        //Iniciando a intenção
        startActivity(intent)
    }
}