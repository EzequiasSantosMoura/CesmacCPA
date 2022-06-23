package br.com.estudosqia.cesmaccpa.ui.activitys

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.estudosqia.cesmaccpa.R
import br.com.estudosqia.cesmaccpa.dao.FormDAO
import br.com.estudosqia.cesmaccpa.dao.QuestoesDAO

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var listView: ListView
    private var indexQuestao: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Bem vindo!", Toast.LENGTH_SHORT).show()

        configPergunta(indexQuestao)
        configAdapterViewAlternativasAtualizavel(indexQuestao)
        configButtonProx()
    }

    private fun configButtonProx() {
        val buttonProx = findViewById<Button>(R.id.main_button_prox)
        buttonProx.setOnClickListener {
            pegaAlternativasSelecionadas()
            mudarQuestao()
            if (indexQuestao == (QuestoesDAO().listaEnuciados().size)) {
                startActivity(Intent(this, FinishActivity::class.java))
            }
            if (indexQuestao == ultimaQuestao()) {
                buttonProx.text = "Enviar"
            }
            if (indexQuestao <= ultimaQuestao()) mostraQuestao()
        }
    }

    private fun ultimaQuestao() = (QuestoesDAO().listaEnuciados().size - 1)

    private fun mostraQuestao() {
        configPergunta(indexQuestao)
        configAdapterViewAlternativasAtualizavel(indexQuestao)
    }

    private fun pegaAlternativasSelecionadas() {
        val listaDeRespostas = mutableListOf<String>()
        for (i in 0..listView.getCount()) {
            if (listView.isItemChecked(i)) {
                listaDeRespostas.add(listView.getItemAtPosition(i).toString())
            }
        }
        FormDAO().add(indexQuestao = indexQuestao, listaDeRespostas)
    }

    private fun mudarQuestao() {
        indexQuestao += 1
    }

    private fun configAdapterViewAlternativasAtualizavel(indexQuestao: Int) {
        listView = findViewById(R.id.listView_auternativas)
        val adapterlistView = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_list_item_multiple_choice,
            QuestoesDAO().listaAuternativas(indexQuestao)
        )
        listView.adapter = adapterlistView
    }

    private fun configPergunta(indexQuestao: Int) {
        val pergunta = findViewById<TextView>(R.id.main_pergunta)
        pergunta.text = QuestoesDAO().listaEnuciados()[indexQuestao]
    }
}