package org.postgres.loja.dao;

import org.postgres.loja.modelo.Cliente;

import javax.persistence.EntityManager;

public class ClienteDao {
    private final EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente) {
        this.em.persist(cliente);
    }

    public Cliente buscarPorId(long id) {
        return em.find(Cliente.class, id);
    }
}
