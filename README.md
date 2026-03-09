# 📋 Sistema Gerenciador de Tarefas

Aplicação desktop desenvolvida em **Java** com **Swing** e **MySQL**, criada para gerenciar tarefas e subtarefas de usuários.  
O sistema permite organizar atividades, acompanhar progresso e gerenciar prioridades.

---

## 🚀 Funcionalidades

- Cadastro de usuários
- Login com criptografia de senha (BCrypt)
- Criação de tarefas
- Edição e exclusão de tarefas
- Gerenciamento de subtarefas
- Definição de status e prioridade
- Persistência de dados com MySQL

---

## 🛠 Tecnologias utilizadas

- **Java 17**
- **Java Swing**
- **JDBC**
- **MySQL**
- **Gradle**
- **BCrypt**

---

## 📂 Estrutura do projeto

ProjetoGerenciadorDeTarefa
│
├── controller
│ └── AutenticacaoController.java
│
├── dao
│ ├── Conexao.java
│ └── UsuarioDAO.java
│
├── model
│ ├── Usuario.java
│ ├── Tarefa.java
│ └── Subtarefa.java
│
└── view
├── TelaLogin.java
├── TelaCadastro.java
└── TelaPrincipal.java


---

## ⚙️ Configuração do banco de dados

1️⃣ Criar banco:

```sql
CREATE DATABASE taskdb;
2️⃣ Usar banco:

USE taskdb;
3️⃣ Criar tabela de usuários:

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(100) NOT NULL UNIQUE,
    senha_hash VARCHAR(255) NOT NULL,
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP
);
▶ Como executar o projeto
Clonar o repositório

git clone https://github.com/seuusuario/gerenciador-tarefas.git
Abrir o projeto na IDE (IntelliJ / VSCode / Eclipse)

Configurar usuário e senha do MySQL na classe:

Conexao.java
Executar a classe:

TelaLogin.java
📌 Objetivo do projeto
Este projeto foi desenvolvido para praticar:

Programação Orientada a Objetos (POO)

Arquitetura MVC

Conexão com banco de dados usando JDBC

Desenvolvimento de interfaces com Java Swing

👨‍💻 Autor
Desenvolvido por Roberson de Oliveira / Heitor Schafer Lima

GitHub:
https://github.com/Biblinho

