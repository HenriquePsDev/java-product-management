package model.dao;

import java.sql.*;

import database.Conexao;
import model.Produto;

import java.util.List;
import java.util.ArrayList;

public class ProdutoDAO {
    
    public void adicionarProduto(Produto p){
        try{
            Connection conn = Conexao.getConexao();
            String sql = "INSERT INTO produto (codigo, nome, descricao, preco, quantidade) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, p.getCodigo());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getDescricao());
            stmt.setDouble(4, p.getPreco());
            stmt.setInt(5, p.getQuantidade());

            int resultado = stmt.executeUpdate();

            if(resultado > 0){
                System.out.println("Produto adicionado com sucesso!");
            }else{
                System.out.println("Produto não adicionado.");
            }
        }catch(SQLException e){
            System.out.println("Erro ao adicionar produto."+e.getMessage());
        }
    }

    public List<Produto> listaDeProdutos() {
        List<Produto> lista = new ArrayList<>();

        try {
            Connection conn = Conexao.getConexao();
            String sql = "SELECT * FROM produto";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setCodigo(rs.getString("codigo"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }

        return lista;
    }
}
