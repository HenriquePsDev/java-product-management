import model.Produto;
import dao.ProdutoDAO;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Estabelece a conexão com o banco (garante que o driver esteja carregado)
        Class.forName("com.mysql.cj.jdbc.Driver");

        Scanner scanner = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();
        int opcao = 0;

        do {
            System.out.println("\n*** Menu de Gerenciamento de Produtos ***");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Deletar Produto");
            System.out.println("5 - Buscar Produto");
            System.out.println("6 - Relatório de Produtos Baixos em Estoque");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    // Caso 2 - Adicionar Produtos
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Digite a quantidade do produto: ");
                    int quantidade = scanner.nextInt();
                    
                    Produto produto = new Produto(nome, descricao, preco, quantidade);
                    // Gerando codigo do produto
                    String codigo = "PROD-" + (10000 + new Random().nextInt(90000)); 
                    produto.setCodigo(codigo);
                    dao.adicionarProduto(produto);
                    break;
                
                case 2:
                    // Caso 2 - Listar Produtos, pode ser implementado aqui
                    break;

                case 3:
                    // Caso 3 - Atualizar Produto
                    break;

                case 4:
                    // Caso 4 - Deletar Produto
                    break;

                case 5:
                    // Caso 5 - Buscar Produto
                    break;

                case 6:
                    // Relatório de Produtos Baixos em Estoque
                    break;

                case 7:
                    System.err.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 7);

        scanner.close();
    }
}
