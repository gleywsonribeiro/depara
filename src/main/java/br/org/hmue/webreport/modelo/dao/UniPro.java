/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.hmue.webreport.modelo.dao;

/**
 *
 * @author gleywson
 */
public class UniPro {
    private String sigla;
    private String descricao;

    public UniPro() {
    }

    public UniPro(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "UniPro{" + "sigla=" + sigla + ", descricao=" + descricao + '}';
    }
    
    
}
