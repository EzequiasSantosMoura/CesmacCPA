package br.com.estudosqia.cesmaccpa.dao

import br.com.estudosqia.cesmaccpa.model.Questao

class FormDAO {

    fun add(indexQuestao: Int, alternaternativas: List<String>) {
        alternaternativas.forEach { alternativa ->
            formulario[indexQuestao].alternativas.clear()
            formulario[indexQuestao].alternativas.add(alternativa)
        }
    }

    fun form(): List<Questao> {
        return formulario.toList()
    }

    companion object {
        private val formulario = mutableListOf(
            Questao(
                enuciado = "Avalie sua atuação pessoal durante a disciplina:",
                alternativas = mutableListOf()
            ),
            Questao(
                enuciado = "Avalie os conteúdos abordados nesta disciplina:",
                alternativas = mutableListOf()
            ),
            Questao(
                enuciado = "Avalie o material instrucional desta disciplina:",
                alternativas = mutableListOf()
            ),
            Questao(
                enuciado = "Avalie as Experiências de Aprendizagem desta disciplina: ",
                alternativas = mutableListOf()
            ),
            Questao(
                enuciado = "Avalie a aprendizagem nesta disciplina:",
                alternativas = mutableListOf()
            ),
            Questao(
                enuciado = "Avalie as aulas on-line (webconferences) desta disciplina:",
                alternativas = mutableListOf()
            ),
            Questao(
                enuciado = "Avalie as obras indicadas nesta disciplina:",
                alternativas = mutableListOf()
            )
        )
    }
}