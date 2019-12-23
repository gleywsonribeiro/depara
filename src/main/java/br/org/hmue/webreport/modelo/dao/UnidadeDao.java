/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.hmue.webreport.modelo.dao;

import br.org.hmue.webreport.modelo.UniPro;
import br.org.hmue.webreport.factory.SingleConnection;
import br.org.hmue.webreport.jsf.util.JsfUtil;
import br.org.hmue.webreport.modelo.ItemUnidade;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gleywson
 */
public class UnidadeDao implements Serializable {

    private final Connection connection;

    public UnidadeDao() {
        connection = SingleConnection.getConnection();
    }

    public List<UniPro> getUnidades() {
        String sql = "SELECT * FROM UNIDADE";
        List<UniPro> lista = new ArrayList<>();

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            ResultSet resultSet = stm.executeQuery();
            while (resultSet.next()) {
                lista.add(new UniPro(resultSet.getString(1), resultSet.getString(2)));
            }
        } catch (SQLException ex) {
            JsfUtil.addErrorMessage("Erro ao buscar siglas de unidades " + ex.getMessage());
        }
        return lista;
    }

    public int[] getTotais() {
        String sql = "select count(*) total, count(cd_depara_integra) cadastrados from depara_unidade";
        int [] totais = new int[2];
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                totais[0] = rs.getInt(1);
                totais[1] = rs.getInt(2);
            }
            
        } catch (SQLException e) {
            System.err.print("Erro");
        }
        
        return totais;
    }

    public List<ItemUnidade> listarItemUnidade(String unidade) {
        List<ItemUnidade> unidades = new ArrayList<>();

        String sql = "select * from depara_unidade where cd_unidade = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, unidade);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ItemUnidade item = new ItemUnidade();
                item.setCodigo(rs.getLong(1));
                item.setSigla(rs.getString(2));
                item.setNome(rs.getString(3));
                item.setDescricao(rs.getString(4));
                item.setFator(rs.getDouble(5));
                item.setDepara(rs.getLong(6));
                item.setNovo(rs.getObject(6) == null);

                unidades.add(item);
            }

        } catch (SQLException ex) {
            JsfUtil.addErrorMessage("Erro ao efetuar a pesquisa: " + ex.getMessage());
        }
        return unidades;
    }
}
