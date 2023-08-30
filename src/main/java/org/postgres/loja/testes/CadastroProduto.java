package org.postgres.loja.testes;

import org.postgres.loja.modelo.ProdutoEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroProduto {

    public static void main(String[] args) {
        ProdutoEntity celular = new ProdutoEntity();
        celular.setName("Xiaomi Redmi");
        celular.setDescription("Muito legal");
        celular.setCost(new BigDecimal("800"));

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("loja");

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }
}
