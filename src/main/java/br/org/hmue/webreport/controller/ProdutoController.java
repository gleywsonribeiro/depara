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

    Produto produto = new Produto();

    private final ProdutoDao dao = new ProdutoDao();
    private final DeparaDao deparaDao = new DeparaDao();

    private List<Produto> produtos = new ArrayList<>();
    private List<Especie> especies = new ArrayList<>();
    private List<Classe> classes = new ArrayList<>();

    private Long especie;
    private Long classe;

    @PostConstruct
    private void init() {
        especies = dao.listarEspecies();
    }

    public void carregaProdutos() {
        produtos = dao.listarProdutos(especie, classe);
    }

    public void atualizaClasse() {
        classes = dao.listarClasses(especie);
    }

    public void salvar() {
        try {
            for (Produto produto : produtos) {
                if (produto.getDeparaProduto() != 0) {
                    deparaDao.inserir(produto);
                } else {
                    if (!produto.isNovo()) {
                        deparaDao.remover(produto);
                    }
                }
            }
            JsfUtil.addMessage("Operação realizada com sucesso!");
            produtos = dao.listarProdutos(especie, classe);
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Erro ao realizar operação");
        }
        
    }

    public List<Produto> getProdutos() {
//        carregaProdutos();
        return produtos;
    }

    public Long getEspecie() {
        return especie;
    }

    public void setEspecie(Long especie) {
        this.especie = especie;
    }

    public List<Especie> getEspecies() {
        return especies;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public Long getClasse() {
        return classe;
    }

    public void setClasse(Long classe) {
        this.classe = classe;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void removeProduto() {
        try {
            if (!produto.isNovo()) {
                deparaDao.remover(produto);
                JsfUtil.addMessage("Removido com sucesso!");
            }
            produtos = dao.listarProdutos(especie, classe);
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Não foi possível remover!");
        }
    }
}
