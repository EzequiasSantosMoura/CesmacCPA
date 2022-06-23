package br.com.estudosqia.cesmaccpa.ui.activitys

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.estudosqia.cesmaccpa.R
import br.com.estudosqia.cesmaccpa.dao.CursosDAO
import br.com.estudosqia.cesmaccpa.model.Conta
import br.com.estudosqia.cesmaccpa.model.GerenciadorDeContas
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivity : AppCompatActivity() {

    val calendario = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        configDadosRegistrar()
        configuraButtonVoltar()
    }
    private fun configDadosRegistrar() {
        val spinnerCampus = findViewById<Spinner>(R.id.register_spinner_campus)
        adapterSpinner(spinnerCampus, CursosDAO().nomePolos())

        spinnerCampus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val indexCampus = position
                val campus = CursosDAO().nomePolos()[indexCampus]

                val spinnerCursos = findViewById<Spinner>(R.id.register_spinner_cursos)
                adapterSpinner(spinnerCursos, CursosDAO().nomeCursos(indexCampus))

                spinnerCursos.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val indexCurso = position
                        val curso = CursosDAO().nomeCursos(indexCampus)[indexCurso]

                        val spinnerTurmas = findViewById<Spinner>(R.id.register_spinner_turmas)
                        adapterSpinner(spinnerTurmas, CursosDAO().nomeTurmas(indexCampus, indexCurso))

                        spinnerTurmas.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                val indexTurma = position
                                val turma = CursosDAO().nomeTurmas(indexCampus, indexCurso)[indexTurma]
                                configData(campus, curso, turma)
                            }
                            override fun onNothingSelected(parent: AdapterView<*>?) {}
                        }
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
    private fun configData(campus: String, curso: String, turma: String) {
        val btnData = findViewById<Button>(R.id.register_button_data)
        val selecionarData =
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                calendario.run {
                    set(Calendar.YEAR, year)
                    set(Calendar.MONTH, month)
                    set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    val formatador = SimpleDateFormat("dd/MM/yyyy", Locale.ITALIAN)
                    val data = formatador.format(calendario.time)
                    btnData.text = data
                    configButtonRegistrar(campus = campus, curso = curso, turma = turma, data = data)
                }
            }
        btnData.setOnClickListener{
            DatePickerDialog(
                this@RegisterActivity,
                selecionarData,
                calendario.get(Calendar.YEAR),
                calendario.get(Calendar.MONTH),
                calendario.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun adapterSpinner(spinner: Spinner, lista: List<String>) {
        val adapterSpinner = ArrayAdapter(
            applicationContext,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            lista
        )
        adapterSpinner.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = adapterSpinner
    }
    private fun configButtonRegistrar(campus: String, curso: String, turma: String, data: String) {
        val registrar = findViewById<Button>(R.id.register_button_cadastrar)
        registrar.setOnClickListener {
            val user = configEntradaUser()
            val password = configEntradaPassword()
            val passwordConfirm = configEntradaPasswordConfirm()
            if (user.length >= 3) {
                if (!verificaSenhas(password, passwordConfirm)) {
                    Toast.makeText(this, "Senhas diferentes", Toast.LENGTH_SHORT).show()
                } else {
                    val conta = Conta(nome = user, senha = password, campus = campus, curso = curso, turma = turma, data = data)
                    GerenciadorDeContas().registrar(conta)
                    Toast.makeText(this, "Conta cadastrada", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } else Toast.makeText(this, "Usuário inválido", Toast.LENGTH_SHORT).show()
        }
    }
    private fun configEntradaUser(): String {
        val campoLoginUser = findViewById<EditText>(R.id.register_input_user)
        return campoLoginUser.text.toString()
    }
    private fun configEntradaPassword(): Int {
        val campoLoginPassword = findViewById<EditText>(R.id.register_input_password)
        val loginPassword = campoLoginPassword.text.toString()
        return if (loginPassword.isBlank()) {
            Int.MAX_VALUE
        } else loginPassword.toInt()
    }
    private fun configEntradaPasswordConfirm(): Int {
        //Iniciando o Edittext
        val campoLoginPasswordConfirm = findViewById<EditText>(R.id.register_input_password_confirm)
        val loginPasswordConfirm = campoLoginPasswordConfirm.text.toString()
        return if (loginPasswordConfirm.isBlank()) {
            Int.MIN_VALUE
        } else loginPasswordConfirm.toInt()
    }
    private fun verificaSenhas(password: Int, passwordConfirm: Int): Boolean {
        return password == passwordConfirm
    }
    private fun configuraButtonVoltar() {
        val voltar = findViewById<Button>(R.id.register_button_voltar)
        voltar.setOnClickListener {
            chamaLoginActivity()
        }
    }
    private fun chamaLoginActivity() {
        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
        startActivity(intent)
    }
}