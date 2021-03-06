package br.org.hmue.webreport.factory;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection implements Serializable {

    private static final String USERNAME = "dbamv";
    private static final String PASSWORD = "prosaude1973";
    private static final String SERVER = "10.79.100.15";
    private static final String PORT = "1521";
    private static final String DATABASE = "prd";
    //Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
    private static final String DATABASE_URL = "jdbc:oracle:thin:@" + SERVER + ":" + PORT + ":" + DATABASE;

    // Classe de conexão com o banco de dados
    private static Connection connection = null;

    static {
        conectar();
    }

    public SingleConnection() {
        conectar();
    }

    private static void conectar() {
        try {

            // Verifica se já existe a conexão
            if (connection == null) {

                /// Registra o driver do banco de dados
                Class.forName("oracle.jdbc.driver.OracleDriver");

                // Faz a conexão com o banco de dados
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

                // Configuração para não commitar automaticamente os dados no banco de dados
                connection.setAutoCommit(false);

                System.out.println("Conectou com sucesso");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
