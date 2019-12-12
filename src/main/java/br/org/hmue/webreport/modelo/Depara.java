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
public class Depara {
    private TipoDepara tipoDepara;
    private final Long multiEmpresa;
    private Long deparaMV;
    private Long deparaIntegra;
    private final String sistema;

    public Depara() {
        this.multiEmpresa = 1L;
        this.sistema = "VSSUPPLY";
    }

    public Depara(TipoDepara tipoDepara, Long deparaMV, Long deparaIntegra) {
        this.tipoDepara = tipoDepara;
        this.deparaMV = deparaMV;
        this.deparaIntegra = deparaIntegra;
        this.multiEmpresa = 1L;
        this.sistema = "VSSUPPLY";
    }

    public TipoDepara getTipoDepara() {
        return tipoDepara;
    }

    public Long getMultiEmpresa() {
        return multiEmpresa;
    }

    public Long getDeparaMV() {
        return deparaMV;
    }

    public Long getDeparaIntegra() {
        return deparaIntegra;
    }

    public String getSistema() {
        return sistema;
    }

    public void setTipoDepara(TipoDepara tipoDepara) {
        this.tipoDepara = tipoDepara;
    }

    public void setDeparaMV(Long deparaMV) {
        this.deparaMV = deparaMV;
    }

    public void setDeparaIntegra(Long deparaIntegra) {
        this.deparaIntegra = deparaIntegra;
    }

    @Override
    public String toString() {
        return "Depara{" + "tipoDepara=" + tipoDepara + ", multiEmpresa=" + multiEmpresa + ", deparaMV=" + deparaMV + ", deparaIntegra=" + deparaIntegra + ", sistema=" + sistema + '}';
    }

    
      
}
