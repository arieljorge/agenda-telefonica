package com.github.arieljorge.service;

import com.github.arieljorge.dao.ContatoDAO;
import com.github.arieljorge.model.Contato;

import java.sql.SQLException;
import java.util.List;

public class AgendaTelefonica {

    private final ContatoDAO dao = new ContatoDAO();

    public void adicionarContato(Contato contato) throws SQLException {
        dao.adicionar(contato);
    }

    public boolean removerContato(String nome) throws SQLException {
        return dao.remover(nome);
    }

    public Contato buscarContato(String nome) throws SQLException {
        return dao.buscar(nome);
    }

    public List<Contato> listarContatos() throws SQLException {
        return dao.listar();
    }

    public boolean atualizarContato(Contato contato) throws SQLException {
        return dao.atualizar(contato);
    }
}
