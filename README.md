# 📦 Sistema de Gerenciamento de Produtos em Java com MySQL

## 🎯 Objetivo
Desenvolver um sistema simples em **Java** que permita gerenciar produtos em um banco **MySQL**, realizando operações **CRUD** (Create, Read, Update, Delete) de forma organizada e seguindo boas práticas de código.

## 📈 Progresso Atual
- ✅ Adicionar Produto  
- ✅ Listar Produtos  
- ✅ Atualizar Produto  
- ✅ Deletar Produto  
- 🚧 Geração automática de código de produto  
- 🚧 Validações de entrada  
- 🚧 Menu de opções interativo  

## 🛠️ Tecnologias Utilizadas
- ☕ **Java 8+**  
- 🐬 **MySQL 5.7+**  
- 📡 **JDBC** (Java Database Connectivity)

## 📁 Estrutura do Projeto
- **src**:  
  - `App.java`  
  - **model**:  
    - `Produto.java`  
  - **dao**:  
    - `ProdutoDAO.java`  
  - **database**:  
    - `Conexao.java`  
    - `script_criacao_banco.sql`  
- **lib**:  
  - `mysql-connector-java-9.2.0.jar`  
- **bin**: arquivos compilados  
- `README.md`

## ▶️ Como Executar
1. **Compile**:
   ```bash
   javac -d bin -cp "lib/mysql-connector-j-9.2.0.jar" src/database/Conexao.java src/model/Produto.java src/dao/ProdutoDAO.java src/App.java

2. **Execute**:
   ```bash
   java -cp "bin;lib/mysql-connector-j-9.2.0.jar" App

