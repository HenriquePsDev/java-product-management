# 📦 Sistema de Gerenciamento de Produtos em Java com MySQL

## 🎯 Objetivo
Desenvolver um sistema simples em **Java** que permita gerenciar produtos em um banco de dados **MySQL**, realizando operações **CRUD** (Create, Read, Update, Delete) de forma organizada e seguindo boas práticas de código.

## 📈 Progresso Atual
- ✅ Adicionar Produto  
- ✅ Listar Produtos  
- ✅ Atualizar Produto  
- ✅ Deletar Produto  
- ✅ Geração automática de código do produto  
- ✅ Menu de opções interativo  
- 🚧 Validações de entrada  

## 🛠️ Tecnologias Utilizadas
- ☕ **Java 8+**  
- 🐬 **MySQL 5.7+**  
- 📡 **JDBC (Java Database Connectivity)**

## 📁 Estrutura do Projeto
```
📦 src/
├── App.java
├── database/
│   ├── Conexao.java
│   └── script_criacao_banco.sql
├── model/
│   └── Produto.java
└── dao/
    └── ProdutoDAO.java
📦 lib/
└── mysql-connector-j-9.2.0.jar
📦 bin/
└── (arquivos compilados)
📄 README.md
```

## ▶️ Como Executar

1. **Compile** os arquivos:
   ```bash
   javac -d bin -cp "lib/mysql-connector-j-9.2.0.jar" src/database/Conexao.java src/model/Produto.java src/dao/ProdutoDAO.java src/App.java
   ```

2. **Execute** o sistema:
   ```bash
   java -cp "bin;lib/mysql-connector-j-9.2.0.jar" App
   ```

> 💡 Obs: Se estiver usando Linux ou macOS, troque `;` por `:` no classpath:
> ```bash
> java -cp "bin:lib/mysql-connector-j-9.2.0.jar" App
> ```

---

Esse projeto foi criado com foco em aprendizado e boas práticas. Ele representa a consolidação de conhecimentos sobre JDBC, organização de código em Java e interação com banco de dados MySQL.
