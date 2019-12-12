/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.hmue.webreport.controller;

import br.org.hmue.webreport.jsf.util.JsfUtil;
import br.org.hmue.webreport.modelo.Depara;
import br.org.hmue.webreport.modelo.TipoDepara;
import br.org.hmue.webreport.modelo.dao.DeparaDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author gleywson
 */
@ManagedBean
@RequestScoped
public class DeparaController {

    DeparaDao dao = new DeparaDao();
    Depara depara = new Depara(TipoDepara.CODIGO_PRODUTO, 17591L, 1989L);

    public void salvar() {
        dao.inserir(depara);
        JsfUtil.addMessage("Inserido com sucesso!");
    }
    
    public void remover() {
        dao.remover(depara);
        JsfUtil.addMessage("removido com sucesso!");
    }
    
    public void atualizar() {
        dao.atualizar(depara);
        JsfUtil.addMessage("Atualizado com sucesso!");
    }
}
