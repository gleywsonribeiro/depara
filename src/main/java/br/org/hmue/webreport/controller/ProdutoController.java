/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.hmue.webreport.controller;

import br.org.hmue.webreport.jsf.util.JsfUtil;
import br.org.hmue.webreport.modelo.Classe;
import br.org.hmue.webreport.modelo.Especie;
import br.org.hmue.webreport.modelo.Produto;
import br.org.hmue.webreport.modelo.dao.DeparaDao;
import br.org.hmue.webreport.modelo.dao.ProdutoDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gleywson
 */
@ManagedBean
@ViewScoped
public class ProdutoController implements Serializable {

    private Produto produto = new Produto();
    private Long codigo;

    private final ProdutoDao dao = new ProdutoDao();
    private final DeparaDao deparaDao = new DeparaDao();

    private List<Produto> produtos;

    @PostConstruct
    private void init() {
        produtos = dao.listarProdutos();
    }

    public void salvar() {
        try {
            for (Produto p : produtos) {
                if (p.getDeparaProduto() != 0) {
                    deparaDao.inserir(p);
                }
            }
            JsfUtil.addMessage("Operação realizada com sucesso!");
            produtos = dao.listarProdutos();
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Erro ao realizar operação");
        }
        
    }

    public void buscarProduto() {
        produto = dao.buscar(codigo);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void removeProduto() {
        try {
            if (!produto.isNovo()) {
                deparaDao.remover(produto);
                JsfUtil.addMessage("Removido com sucesso!");
            }
            produtos = dao.listarProdutos();
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Não foi possível remover!");
        }
    }

}
