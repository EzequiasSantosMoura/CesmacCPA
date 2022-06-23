package br.com.estudosqia.cesmaccpa.model

import br.com.estudosqia.cesmaccpa.dao.ContasDAO

class GerenciadorDeContas {
    fun registrar(conta: Conta) {
        ContasDAO().add(conta)
    }

    fun entrar(user: String, password: Int): Boolean {
        val nomeContas = mutableListOf<String>()
        var entrar = false
        ContasDAO().contas().forEach { conta ->
            nomeContas.add(conta.nome)
        }
        if (user in nomeContas) ContasDAO().contas().forEach { conta ->
            if (conta.nome == user && conta.senha == password) entrar = true
        }
        usuario = user
        return entrar
    }

    fun user(): String {
        return usuario
    }

    companion object {
        private var usuario = ""
    }
}