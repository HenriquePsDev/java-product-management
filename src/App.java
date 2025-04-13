import model.Produto;
import model.dao.ProdutoDAO;

import java.util.List;

import database.Conexao;

import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {

        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.listaDeProdutos();
        
        // Imprimindo os produtos da lista
        for (Produto p : produtos) {
            System.out.println("ID: " + p.getId());
            System.out.println("Código: " + p.getCodigo());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Descrição: " + p.getDescricao());
            System.out.println("Preço: " + p.getPreco());
            System.out.println("Quantidade: " + p.getQuantidade());
            System.out.println("----------------------------");
        }
    }
}
