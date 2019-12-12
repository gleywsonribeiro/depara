/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.hmue.webreport.modelo.dao;

import br.org.hmue.webreport.factory.SingleConnection;
import br.org.hmue.webreport.modelo.Produto;
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
public class ProdutoDao implements Serializable {
    private final Connection connection;

    public ProdutoDao() {
        connection = SingleConnection.getConnection();
    }
    
    public List<Produto> listarTudo() {
        List<Produto> lista = new ArrayList<>();

        String sql = "select * from depara_produto where rownum <= 10";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Produto p = new Produto();
                p.setCodigo(resultSet.getLong("cd_produto"));
                p.setDescricao(resultSet.getString("ds_produto"));
                p.setEspecie(resultSet.getString("ds_especie"));
                p.setClasse(resultSet.getString("ds_classe"));
                p.setSubclasse(resultSet.getString("ds_sub_cla"));
                p.setDeparaProduto((Long)resultSet.getObject("cd_depara_integra"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
