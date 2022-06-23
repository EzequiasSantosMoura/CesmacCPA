package br.com.estudosqia.cesmaccpa.dao

import br.com.estudosqia.cesmaccpa.model.Curso
import br.com.estudosqia.cesmaccpa.model.Polo

class CursosDAO {

    fun nomePolos(): List<String> {
        val polos = mutableListOf<String>()
        daoCursos.forEach { polo ->
            polos.add(polo.nome)
        }
        return polos
    }

    fun nomeCursos(indexCampus: Int): List<String> {
        val cursosDoCampusEscolhido = mutableListOf<String>()
        daoCursos[indexCampus].cursos.forEach{ curso ->
            cursosDoCampusEscolhido.add(curso.nome)
        }
        return cursosDoCampusEscolhido
    }

    fun nomeTurmas(indexCampus: Int, indexCurso: Int): List<String> {
        return daoCursos[indexCampus].cursos[indexCurso].turmas.toList()
    }

    companion object {
        private val daoCursos = mutableListOf(
            Polo(
                nome = "Agreste",
                cursos = listOf(
                    Curso(nome = "Direito", turmas = listOf("A", "B", "C")),
                    Curso(nome = "Enfermagem", turmas = listOf("A", "B"))
                )
            ),
            Polo(
                nome = "Sertão",
                cursos =  listOf(
                    Curso(nome = "Direito", turmas = listOf("A", "B", "C", "D"))
                )
            ),
            Polo(nome = "Maceió",
                cursos =  listOf(
                    Curso(nome = "Administração", turmas = listOf("A", "B", "C", "D", "E")),
                    Curso(nome = "Agronomia", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Arquitetura e urbanismo", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Biomedicina", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Ciências Biológicas", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Ciências Contábeis", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Design", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Direito", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Educação Física", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Enfermagem", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Engenharia Civil", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Engenharia de Produção", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Engenharia de Software", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Engenharia Mecatrônica", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Farmácia", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Fisioterapia", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Medicina", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Medicina Veterinária", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Nutrição", turmas = listOf("A", "B", "C", "D")),
                    Curso(nome = "Odontologia", turmas = listOf("A", "B")),
                    Curso(nome = "Pedagogia", turmas = listOf("A", "B", "C")),
                    Curso(nome = "Psicologia", turmas = listOf("A")),
                    Curso(nome = "Sistemas de Informação", turmas = listOf("A", "B", "C", "D", "E", "F", "G"))
                )
            )
        )
    }
}