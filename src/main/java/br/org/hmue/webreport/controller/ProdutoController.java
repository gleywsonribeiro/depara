/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.hmue.webreport.controller;

import br.org.hmue.webreport.jsf.util.JsfUtil;
import br.org.hmue.webreport.modelo.Produto;
import br.org.hmue.webreport.modelo.dao.ProdutoDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gleywson
 */
@ManagedBean
@ViewScoped
public class ProdutoController implements Serializable {

   
    private final ProdutoDao dao = new ProdutoDao();
    
    private List<Produto> produtos = new ArrayList<>();
    
    public void carregaProdutos() {
        produtos = dao.listarTudo();
        JsfUtil.addMessage("Produtos carregados com sucesso!");
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    
}
