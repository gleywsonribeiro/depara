/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.hmue.webreport.modelo.dao;

import br.org.hmue.webreport.factory.SingleConnection;
import br.org.hmue.webreport.modelo.Depara;
import br.org.hmue.webreport.modelo.ItemUnidade;
import br.org.hmue.webreport.modelo.Produto;
import br.org.hmue.webreport.modelo.TipoDepara;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gleywson
 */
public class DeparaDao {

    private final Connection connection;

    public DeparaDao() {
        connection = SingleConnection.getConnection();
    }

    public void inserir(Produto produto) {
        Depara depara = new Depara(TipoDepara.CODIGO_PRODUTO, produto.getCodigo(), produto.getDeparaProduto());
        if (produto.isNovo()) {
            inserir(depara);
        } else {
            atualizar(depara);
        }
    }
    
    public void inserir(ItemUnidade unidade) {
        Depara depara = new Depara(TipoDepara.CODIGO_UNIDADE, unidade.getCodigo(), unidade.getDepara());
        if (unidade.isNovo()) {
            inserir(depara);
        } else {
            atualizar(depara);
        }
    }

    public void remover(Produto produto) {
        Depara depara = new Depara(TipoDepara.CODIGO_PRODUTO, produto.getCodigo(), produto.getDeparaProduto());
        remover(depara);
    }
    
    public void remover(ItemUnidade unidade) {
        Depara depara = new Depara(TipoDepara.CODIGO_UNIDADE, unidade.getCodigo(), unidade.getDepara());
        remover(depara);
    }

    public void inserir(Depara depara) {
        String sql = "insert into mvintegra.depara values(?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setString(1, depara.getTipoDepara().toString());
            statement.setLong(2, depara.getMultiEmpresa());
            statement.setLong(3, depara.getDeparaMV());
            statement.setLong(4, depara.getDeparaIntegra());
            statement.setString(5, depara.getSistema());

            statement.execute();
            connection.commit();

        } catch (SQLException exp) {
            try {
                connection.rollback();// Reverte caso dê algum erro
            } catch (SQLException e1) {
            }
        }
    }

    public void atualizar(Depara depara) {
        try {

            String sql = "update mvintegra.depara set cd_depara_integra = ?"
                    + " where tp_depara = ?"
                    + " and cd_depara_mv = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, depara.getDeparaIntegra());
            statement.setString(2, depara.getTipoDepara().toString());
            statement.setLong(3, depara.getDeparaMV());

            statement.execute();
            connection.commit();

        } catch (SQLException exp) {
            try {
                connection.rollback();// Reverte caso dê algum erro
            } catch (SQLException e1) {
            }
        }
    }

    public void remover(Depara depara) {
        try {

            String sql = "delete from mvintegra.depara"
                    + " where tp_depara = ?"
                    + " and cd_depara_mv = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, depara.getTipoDepara().toString());
            statement.setLong(2, depara.getDeparaMV());

            statement.execute();
            connection.commit();

        } catch (SQLException exp) {
            try {
                connection.rollback();// Reverte caso dê algum erro
            } catch (SQLException e1) {
            }
        }
    }

}
