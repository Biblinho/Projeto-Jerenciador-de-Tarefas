-- apagar banco se existir
DROP DATABASE IF EXISTS taskdb;

-- criar banco
CREATE DATABASE taskdb;

-- usar banco
USE taskdb;

-- =========================
-- TABELA USUARIOS
-- =========================

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(100) NOT NULL UNIQUE,
    senha_hash VARCHAR(255) NOT NULL,
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- TABELA TAREFAS
-- =========================

CREATE TABLE tarefas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descricao TEXT,
    status VARCHAR(50) DEFAULT 'PENDENTE',
    prioridade VARCHAR(50) DEFAULT 'MEDIA',
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_id INT NOT NULL,

    FOREIGN KEY (usuario_id)
        REFERENCES usuarios(id)
        ON DELETE CASCADE
);

-- =========================
-- TABELA SUBTAREFAS
-- =========================

CREATE TABLE subtarefas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    concluida BOOLEAN DEFAULT FALSE,
    tarefa_id INT NOT NULL,

    FOREIGN KEY (tarefa_id)
        REFERENCES tarefas(id)
        ON DELETE CASCADE
);

-- =========================
-- DADOS DE TESTE
-- =========================

INSERT INTO usuarios (nome_usuario, senha_hash)
VALUES ('admin', 'hash_exemplo');

INSERT INTO tarefas (titulo, descricao, usuario_id)
VALUES
('Estudar Java', 'Revisar Swing e JDBC', 1),
('Fazer projeto', 'Continuar sistema gerenciador de tarefas', 1);

INSERT INTO subtarefas (titulo, tarefa_id)
VALUES
('Criar banco de dados', 1),
('Criar tela de login', 1),
('Criar DAO', 2);

SELECT * FROM usuarios;