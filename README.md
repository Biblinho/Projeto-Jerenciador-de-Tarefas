Sistema Gerenciador de Tarefas

Este projeto é uma aplicação desktop desenvolvida em Java utilizando Java Swing para a interface gráfica e MySQL para persistência de dados. O sistema permite gerenciar usuários, tarefas e subtarefas, oferecendo uma forma simples de organizar atividades e acompanhar o progresso das tarefas.

Funcionalidades

Cadastro e autenticação de usuários

Criação, edição e exclusão de tarefas

Organização de tarefas por status e prioridade

Adição de subtarefas

Persistência de dados em banco de dados MySQL

Interface gráfica construída com Java Swing

Tecnologias utilizadas

Java 17

Java Swing (Interface gráfica)

JDBC (conexão com banco de dados)

MySQL

Gradle (gerenciamento de dependências)

BCrypt (criptografia de senha)

Estrutura do projeto

O projeto segue uma organização baseada em camadas para facilitar a manutenção:

model → classes de entidades (Usuario, Tarefa, Subtarefa)

dao → acesso ao banco de dados

controller → lógica da aplicação

view → interface gráfica (telas)

Como executar o projeto

Clone o repositório

Crie o banco de dados MySQL

Execute o script SQL para criar as tabelas

Configure usuário e senha do banco na classe de conexão

Execute a classe principal do projeto

Objetivo

Este projeto foi desenvolvido com o objetivo de praticar conceitos de programação orientada a objetos, arquitetura MVC, integração com banco de dados e desenvolvimento de interfaces gráficas em Java. ()
