package database;

import java.sql.*;

public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3306/gerenciamento_produtos";
    private static final String user = "root";
    private static final String password = "";

    private static Connection conn;

    public static Connection getConexao() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fazer conexão: " + e.getMessage());
        }
        return conn;
    }

    public static void closeConexao() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão fechada");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
