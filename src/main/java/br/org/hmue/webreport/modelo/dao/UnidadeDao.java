/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.hmue.webreport.modelo.dao;

import br.org.hmue.webreport.factory.SingleConnection;
import br.org.hmue.webreport.jsf.util.JsfUtil;
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
public class UnidadeDao {

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
//                UniPro pro = 
//                p.setCodigo(resultSet.getLong("cd_produto"));
//                p.setDescricao(resultSet.getString("ds_produto"));

                lista.add(new UniPro(resultSet.getString(1), resultSet.getString(2)));
            }
        } catch (SQLException ex) {
            JsfUtil.addErrorMessage("Erro ao buscar siglas de unidades " + ex.getMessage());
        }
        return lista;
    }
}
