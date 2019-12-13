/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.hmue.webreport.modelo.dao;

import br.org.hmue.webreport.factory.SingleConnection;
import br.org.hmue.webreport.jsf.util.JsfUtil;
import br.org.hmue.webreport.modelo.Classe;
import br.org.hmue.webreport.modelo.Especie;
import br.org.hmue.webreport.modelo.Produto;
import br.org.hmue.webreport.modelo.SubClasse;
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
                
                Especie especie = new Especie(resultSet.getLong("cd_especie"), resultSet.getString("ds_especie"));
                Classe classe = new Classe(resultSet.getLong("cd_classe"), resultSet.getString("ds_classe"), especie);
                SubClasse subClasse = new SubClasse(resultSet.getLong("cd_sub_cla"), resultSet.getString("ds_sub_cla"), classe);
                
                p.setEspecie(especie);
                p.setClasse(classe);
                p.setSubclasse(subClasse);
                
                p.setDeparaProduto((Long) resultSet.getObject("cd_depara_integra"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<Especie> listarEspecies() {
        List<Especie> lista = new ArrayList<>();

        String sql = "select e.cd_especie, e.ds_especie from especie e ";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                lista.add(new Especie(resultSet.getLong("cd_especie"), resultSet.getString("ds_especie")));
            }

        } catch (SQLException e) {
            JsfUtil.addErrorMessage("Erro ao carregar espécies " + e.getMessage());
        }

        return lista;
    }
    
    public List<Classe> listarClasses(Long codigoEspecie) {
        List<Classe> lista = new ArrayList<>();

        String sql = "select c.cd_classe, c.ds_classe from classe c where c.cd_especie = " + codigoEspecie;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                lista.add(new Classe(resultSet.getLong("cd_classe"), resultSet.getString("ds_classe"), null));
            }

        } catch (SQLException e) {
            JsfUtil.addErrorMessage("Erro ao carregar classes " + e.getMessage());
        }

        return lista;
    }
    
    public List<SubClasse> listarSubClasses(Long codigoClasse) {
        List<SubClasse> lista = new ArrayList<>();

        String sql = "select s.cd_sub_cla, s.ds_sub_cla from sub_clas s where s.cd_classe = " + codigoClasse;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                lista.add(new SubClasse(resultSet.getLong("cd_sub_cla"), resultSet.getString("ds_sub_cla"), null));
            }

        } catch (SQLException e) {
            JsfUtil.addErrorMessage("Erro ao carregar SubClasses " + e.getMessage());
        }

        return lista;
    }

}
