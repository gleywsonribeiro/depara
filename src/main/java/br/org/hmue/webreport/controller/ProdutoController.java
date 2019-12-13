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
import br.org.hmue.webreport.modelo.SubClasse;
import br.org.hmue.webreport.modelo.dao.ProdutoDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PostLoad;

/**
 *
 * @author gleywson
 */
@ManagedBean
@ViewScoped
public class ProdutoController implements Serializable {

    private final ProdutoDao dao = new ProdutoDao();

    private List<Produto> produtos = new ArrayList<>();
    private List<Especie> especies = new ArrayList<>();
    private List<Classe> classes = new ArrayList<>();
    private List<SubClasse> subClasses = new ArrayList<>();
    private Long especie;
    private Long classe;
    private Long subclasse;

    @PostConstruct
    private void init() {
        especies = dao.listarEspecies();
    }

    public void carregaProdutos() {
        produtos = dao.listarTudo();
        JsfUtil.addMessage("Produtos carregados com sucesso!");
    }

    public void atualizaClasse() {
        classes = dao.listarClasses(especie);
    }
    
    public void atualizaSubClasse() {
        subClasses = dao.listarSubClasses(classe);
    }
    
    public List<Produto> getProdutos() {
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

    public List<SubClasse> getSubClasses() {
        return subClasses;
    }

    public Long getClasse() {
        return classe;
    }

    public void setClasse(Long classe) {
        this.classe = classe;
    }

    public Long getSubclasse() {
        return subclasse;
    }

    public void setSubclasse(Long subclasse) {
        this.subclasse = subclasse;
    }

    
}
