package br.com.emerson.controller;

import br.com.emerson.dao.ProdutoDao;
import br.com.emerson.domain.Produto;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProdutoController implements Serializable {

    private Produto produto;
    private List<Produto> produtos;
    private ProdutoDao dao;

    @PostConstruct
    public void init() {
        dao = new ProdutoDao();
        produto = new Produto();
        produtos = dao.listar();
    }

    public void salvar() {
        dao.salvar(produto);
        produto = new Produto();
        produtos = dao.listar();
    }

    public void deletar(Produto produto) {
        dao.deletar(produto);
        produtos = dao.listar();
    }

    public Produto getProduto() { return produto; }
    public List<Produto> getProdutos() { return produtos; }
}