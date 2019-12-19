/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.hmue.webreport.controller;

import br.org.hmue.webreport.modelo.dao.UniPro;
import br.org.hmue.webreport.modelo.dao.UnidadeDao;
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
public class UnidadeController {

    private UnidadeDao dao = new UnidadeDao();
    private List<UniPro> siglas;
    private String sigla;
    
    @PostConstruct
    private void init() {
        siglas = dao.getUnidades();
    }

    public List<UniPro> getSiglas() {
        return siglas;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    
    
    
}
