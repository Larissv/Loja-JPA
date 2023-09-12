package org.postgres.loja.testes;

import org.postgres.loja.dao.CategoriaDao;
import org.postgres.loja.dao.ProdutoDao;
import org.postgres.loja.modelo.Categoria;
import org.postgres.loja.modelo.Produto;
import org.postgres.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroProduto {

    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
