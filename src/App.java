import model.Produto;
import dao.ProdutoDAO;

import java.util.List;
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
                    // Caso 2 - Listar Produtos
                    List<Produto> produtos = dao.listaDeProdutos();
                    if(produtos.isEmpty()){
                        System.out.println("A lista de produtos está vazia.");
                    }else{
                        System.out.println("Lista de produtos:");
                        for(Produto p : produtos){
                            System.out.printf("Id: %d\n", p.getId());
                            System.out.printf("Código: %s\n", p.getCodigo());
                            System.out.printf("Nome: %s\n", p.getNome());
                            System.out.printf("Descrição: %s\n", p.getDescricao());
                            System.out.printf("Preço: %.2f\n", p.getPreco());
                            System.out.printf("Quantidade: %d\n\n", p.getQuantidade());
                        }
                    }

                    break;

                    case 3:
                    // Caso 3 - Atualizar Produto
                    System.out.print("Digite o id do produto que deseja atualizar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                
                    // Buscar o produto pelo id para obter o código
                    Produto produtoExistente = dao.buscarProdutoPorId(id);
                    
                    if (produtoExistente == null) {
                        System.out.println("Produto não encontrado!");
                    } else {
                        System.out.print("Digite o novo nome do produto: ");
                        nome = scanner.nextLine();
                        System.out.print("Digite a nova descrição do produto: ");
                        descricao = scanner.nextLine();
                        System.out.print("Digite o novo preço do produto: ");
                        preco = scanner.nextDouble();
                        System.out.print("Digite a nova quantidade do produto: ");
                        quantidade = scanner.nextInt();
                        
                        Produto produtoAtualizado = new Produto(nome, descricao, preco, quantidade);
                        produtoAtualizado.setId(id);
                        produtoAtualizado.setCodigo(produtoExistente.getCodigo());
                        
                        dao.atualizarProduto(produtoAtualizado);
                        System.out.println("Produto atualizado com sucesso!");
                    }
                    break;
                

                case 4:
                    // Caso 4 - Deletar Produto
                    System.out.println("Digite o id do produto que deseja deletar: ");
                    id = scanner.nextInt();
                    dao.deletarProduto(id);
                    System.out.println("Produto deletado com sucesso!");
                    break;

                    case 5:
                    // Caso 5 - Buscar Produto
                    System.out.print("Digite o id do produto que deseja buscar: ");
                    int idBuscar = scanner.nextInt();
                    Produto produtoBuscado = dao.buscarProdutoPorId(idBuscar);
                    
                    if (produtoBuscado != null) {
                        System.out.printf("Id: %d\n", produtoBuscado.getId());
                        System.out.printf("Código: %s\n", produtoBuscado.getCodigo());
                        System.out.printf("Nome: %s\n", produtoBuscado.getNome());
                        System.out.printf("Descrição: %s\n", produtoBuscado.getDescricao());
                        System.out.printf("Preço: %.2f\n", produtoBuscado.getPreco());
                        System.out.printf("Quantidade: %d\n", produtoBuscado.getQuantidade());
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
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
