-- Criação do banco de dados e da tabela de produtos

CREATE DATABASE IF NOT EXISTS gerenciamento_produtos;

USE gerenciamento_produtos;

CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(10) UNIQUE NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL
);
