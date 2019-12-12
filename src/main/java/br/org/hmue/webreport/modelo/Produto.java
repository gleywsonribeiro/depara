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
public class Produto {
    private long codigo;
    private String descricao;
    private String especie;
    private String classe;
    private String subclasse;
    
    private Long deparaProduto;

    public Produto() {
    }

    public Produto(long codigo, String descricao, String especie, String classe, String subclasse) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.especie = especie;
        this.classe = classe;
        this.subclasse = subclasse;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getSubclasse() {
        return subclasse;
    }

    public void setSubclasse(String subclasse) {
        this.subclasse = subclasse;
    }

    public Long getDeparaProduto() {
        return deparaProduto;
    }

    public void setDeparaProduto(Long deparaProduto) {
        this.deparaProduto = deparaProduto;
    }

   
}
