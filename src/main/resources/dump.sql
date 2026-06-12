CREATE TABLE contato (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL
);

INSERT INTO contato (id, nome, telefone, email)
VALUES
    (1, 'Ariel', '34999999999', 'ariel@email.com'),
    (2, 'João', '31988888888', 'joao@email.com');