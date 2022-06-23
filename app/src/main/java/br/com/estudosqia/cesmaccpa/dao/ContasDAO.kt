package br.com.estudosqia.cesmaccpa.dao

import br.com.estudosqia.cesmaccpa.model.Conta

class ContasDAO {

    fun add(conta: Conta) {
        contasDAO.add(conta)
    }

    fun contas(): List<Conta> {
        return contasDAO.toList()
    }

    companion object {
        private val contasDAO = mutableListOf<Conta>()
    }
}