package org.postgres.loja.dao;

import org.postgres.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ProdutoDao {
    private final EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }
}
