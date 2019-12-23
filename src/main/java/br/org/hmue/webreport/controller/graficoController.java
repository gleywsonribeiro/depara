/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.hmue.webreport.controller;

import br.org.hmue.webreport.modelo.dao.ProdutoDao;
import br.org.hmue.webreport.modelo.dao.UnidadeDao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
@ViewScoped
public class graficoController implements Serializable {

    private PieChartModel pieModelUnidade;
    private PieChartModel pieModelProduto;

    private UnidadeDao unidadeDao = new UnidadeDao();
    private ProdutoDao produtoDao = new ProdutoDao();

    @PostConstruct
    public void init() {
        createPieUnidades();
        createPieProdutos();
    }

    private void createPieUnidades() {
        pieModelUnidade = new PieChartModel();

        int[] valores = unidadeDao.getTotais();

        int pendente = valores[0] - valores[1];

        pieModelUnidade.set("Cadastrados", valores[1]);
        pieModelUnidade.set("Pendentes", pendente);

        pieModelUnidade.setTitle("Cadastro de Unidades");
        pieModelUnidade.setLegendPosition("e");
        pieModelUnidade.setFill(false);
        pieModelUnidade.setShowDataLabels(true);
        pieModelUnidade.setDiameter(150);
        pieModelUnidade.setShadow(false);
    }

    private void createPieProdutos() {
        pieModelProduto = new PieChartModel();
        int[] valores = produtoDao.totais();

        int pendente = valores[0] - valores[1];

        pieModelProduto.set("Cadastrados", valores[1]);
        pieModelProduto.set("Pendentes", pendente);

        pieModelProduto.setTitle("Cadastro de Produtos");
        pieModelProduto.setLegendPosition("e");
        pieModelProduto.setFill(false);
        pieModelProduto.setShowDataLabels(true);
        pieModelProduto.setDiameter(150);
        pieModelProduto.setShadow(false);
    }

    public PieChartModel getPieModelUnidade() {
        return pieModelUnidade;
    }

    public PieChartModel getPieModelProduto() {
        return pieModelProduto;
    }

}
