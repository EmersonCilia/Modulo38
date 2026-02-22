package br.com.emerson.dao;

import br.com.emerson.config.JPAUtil;
import br.com.emerson.domain.Produto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProdutoDao {

    public void salvar(Produto produto) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Produto> listar() {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        try {
            return em.createQuery("FROM Produto", Produto.class).getResultList();
        } finally {
            em.close();
        }
    }
    public void deletar(Produto produto) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            produto = em.merge(produto);
            em.remove(produto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}