import database.*;
import java.sql.Connection;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Connection conn = Conexao.getConexao();
        Conexao.closeConexao();

    }
}
