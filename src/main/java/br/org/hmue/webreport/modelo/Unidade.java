/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.hmue.webreport.modelo;

/**
 *
 * @author gleywson
 */
public class Unidade {

    private Long codigo;        //cd_itunidade
    private String sigla;       //cd_unidade
    private String descricao;   //ds_itunidade
    private Double fator;       //vl_fator
    private Long depara;        //cd_depara_integra

    public Unidade() {
    }

    public Unidade(Long codigo, String sigla, String descricao, Double fator, Long depara) {
        this.codigo = codigo;
        this.sigla = sigla;
        this.descricao = descricao;
        this.fator = fator;
        this.depara = depara;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public Double getFator() {
        return fator;
    }

    public void setFator(Double fator) {
        this.fator = fator;
    }

    public Long getDepara() {
        return depara;
    }

    public void setDepara(Long depara) {
        this.depara = depara;
    }

}
