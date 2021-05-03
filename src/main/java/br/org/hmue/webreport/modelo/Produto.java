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
    private Long codigo;
    private String descricao;
    private Especie especie;
    private Classe classe;
    private SubClasse subclasse;
    private boolean novo;
    
    private Long deparaProduto;

    public Produto() {
    }

    public Produto(long codigo, String descricao, Especie especie, Classe classe, SubClasse subclasse, boolean novo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.especie = especie;
        this.classe = classe;
        this.subclasse = subclasse;
        this.novo = novo;
    }


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public SubClasse getSubclasse() {
        return subclasse;
    }

    public void setSubclasse(SubClasse subclasse) {
        this.subclasse = subclasse;
    }

    public Long getDeparaProduto() {
        return deparaProduto;
    }

    public void setDeparaProduto(Long deparaProduto) {
        this.deparaProduto = deparaProduto;
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", descricao=" + descricao + ", novo=" + novo + ", deparaProduto=" + deparaProduto + '}';
    }

    
    
    

    
    
   
}
