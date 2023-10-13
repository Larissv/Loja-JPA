package org.postgres.loja.dao;

import org.postgres.loja.modelo.Pedido;
import org.postgres.loja.modelo.Produto;
import org.postgres.loja.modelo.RelatorioDeVendas;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class PedidoDao {
    private final EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido) {
        this.em.persist(pedido);
    }
    public BigDecimal valorTotalVendido() {
        String jpql = "select sum(p.valorTotal) from Pedido p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public List<RelatorioDeVendas> relatorioDeVendas() {
        String jpql = "select new org.postgres.loja.modelo.RelatorioDeVendas(" +
                "produto.nome, " +
                "sum(item.quantidade), " +
                "max(pedido.data))" +
                "from Pedido pedido " +
                "join pedido.itens item " +
                "join item.produto produto " +
                "group by produto.nome " +
                "order by item.quantidade desc";

        return em.createQuery(jpql, RelatorioDeVendas.class).getResultList();
    }

    public Pedido buscarPedidoComCliente(Long id) {
        return em.createQuery("select p from Pedido p " +
                                        "join fetch p.cliente where p.id = :id", Pedido.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}