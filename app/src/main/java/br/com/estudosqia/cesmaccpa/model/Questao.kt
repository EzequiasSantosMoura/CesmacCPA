package br.com.estudosqia.cesmaccpa.model

data class Questao(
    val enuciado: String,
    val alternativas: MutableList<String>
    )