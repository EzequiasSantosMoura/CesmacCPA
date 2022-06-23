package br.com.estudosqia.cesmaccpa.dao

import br.com.estudosqia.cesmaccpa.model.Questao

class QuestoesDAO {

    fun listaEnuciados(): MutableList<String> {
        val enuciados = mutableListOf<String>()
        daoQuetoes.forEach {
            enuciados.add(it.enuciado)
        }
        return enuciados
    }

    fun listaAuternativas(indexQuestao: Int): List<String> {
        return daoQuetoes[indexQuestao].alternativas.toList()
    }

    companion object {
        private val daoQuetoes = listOf(
            Questao(
                enuciado = "Avalie sua atuação pessoal durante a disciplina:",
                alternativas = mutableListOf(
                    "Estive motivado durante o decorrer de toda a disciplina",
                    "Além das referências essenciais indicadas, tive a oportunidade de explorar as demais referências sugeridas",
                    "Consegui me organizar para o estudo, conciliando os trabalhos com as atividades pessoais e profissionais",
                    "Participei efetivamente das atividades individuais propostas (tarefas)",
                    "Contribuí com meus conhecimentos, ideias e experiências para os trabalhos desenvolvidos em grupo (fóruns)",
                    "Explorei o potencial interativo do AVA, compartilhando e debatendo com o(a) professor(a) e demais colegas",
                    "As opiniões de colegas e do(a) professor(a) contribuíram para o meu processo de aprendizagem",
                    "As discussões e debates realizados no AVA foram importantes para minha tomada de posição frente aos temas",
                    "Dentro das minhas condições práticas e de organização, os prazos para a realização das atividades foram suficientes",
                    "Sinto-me motivado(a) a aplicar os conhecimentos obtidos nesta disciplina do curso"
                )
            ),
            Questao(
                enuciado = "Avalie os conteúdos abordados nesta disciplina:",
                alternativas = mutableListOf(
                    "Foram pertinentes e atualizados. Por meio deles pude ter uma boa visão sobre os assuntos ligados à disciplina",
                    "A linguagem utilizada foi acessível e por meio do tom empregado estabeleci uma empatia com os conteúdos",
                    "Os conceitos apresentados foram suficientes para a realização das atividades propostas colaborativamente",
                    "Os hiperlinks foram pertinentes, possibilitando-me novas referências sobre o assunto",
                    "O grau de profundidade e abrangência dos conteúdos esteve de acordo com as minhas expectativas",
                    "As referências complementares permitiram aprofundamento dos conceitos que mais me interessaram",
                )
            ),
            Questao(
                enuciado = "Avalie o material instrucional desta disciplina:",
                alternativas = mutableListOf(
                    "O material disponibilizado foi suficiente para a aprendizagem do conteúdo",
                    "As leituras complementares e dicas do(a) professor(a) enriqueceram meu aprendizado",
                    "As referências bibliográficas do material foram significativas para meu aprendizado",
                    "Os textos eram adequados ao tempo previsto para a sua leitura",
                    "A linguagem utilizada no material foi condizente com meu grau de formação "
                )
            ),
            Questao(
                enuciado = "Avalie as Experiências de Aprendizagem desta disciplina: ",
                alternativas = mutableListOf(
                    "Ocorreram de forma eficaz em virtude da utilização das ferramentas propostas",
                    "Provocaram e incentivaram a reflexão sobre os temas tratados",
                    "Incentivaram a colaboração",
                    "Ofereceram oportunidade de reflexão sobre a futura aplicação dos conceitos e fundamentos teóricos discutidos",
                    "Foram condizentes com a carga horária prevista de estudo a distância",
                    "O feedback oferecido pelo(a) professor(a) em minhas atividades foi adequado, suficiente e contribuiu para a compreensão dos conteúdos que estudei"
                )
            ),
            Questao(
                enuciado = "Avalie a aprendizagem nesta disciplina:",
                alternativas = mutableListOf(
                    "Consegui estabelecer um vínculo com o(a) professor(a) e tutor(a)",
                    "O(a) professor(a) esteve disposto(a) a esclarecer as minhas dúvidas",
                    "O(a) tutor(a) esteve disposto(a) a esclarecer as minhas dúvidas",
                    "As orientações dadas pelo(a) professor(a) para a realização das atividades e trabalhos foram adequadas e suficientes",
                    "Apesar da distância física, pude perceber a presença de pessoas acompanhando meu trabalho e dispostas a me ajudar quando necessário",
                    "O(A) professor(a) manteve um relacionamento amigável com o grupo, tentando constantemente estimular a participação do grupo e de cada um",
                    "O(A) tutor(a) manteve um relacionamento amigável com o grupo, tentando constantemente estimular a participação do grupo e de cada um",
                    "A metodologia de trabalho colaborativo utilizada pelo(a) professor(a) contribuiu para a compreensão dos conceitos discutidos",
                    "Os critérios de avaliação estabelecidos pelo(a) professor(a) foram claros e bem definidos",
                    "A participação do(a) professor(a) nos debates e discussões no Ambiente Virtual foi essencial para que estas interações tivessem um bom resultado",
                    "A participação do(a) tutor(a) nos debates e discussões no Ambiente Virtual foi essencial para que estas interações tivessem um bom resultado",
                    "Os feedbacks das atividades foram feitos em tempo adequado pelo(a) professor(a)"
                )
            ),
            Questao(
                enuciado = "Avalie as aulas on-line (webconferences) desta disciplina:",
                alternativas = mutableListOf(
                    "As webconferences tiveram uma linguagem clara e acessível",
                    "As webconferences contribuíram para meu entendimento sobre as aplicações práticas dos conteúdos abordados",
                    "As webconferences tiveram uma duração adequada",
                    "As webconferences abordaram exemplos pertinentes e enriquecedores para os conteúdos estudados",
                    "As webconferences tiveram boa qualidade técnica e foram agradáveis de assistir"
                )
            ),
            Questao(
                enuciado = "Avalie as obras indicadas nesta disciplina:",
                alternativas = mutableListOf(
                    "O acervo de obras disponível na Biblioteca Virtual são adequadamente abrangentes em relação às necessidades da disciplina",
                    "O acervo de obras disponível na Biblioteca Virtual são adequadamente atualizados em relação às necessidades da disciplina"
                )
            )
        )
    }
}