CREATE DATABASE meu_banco;
USE meu_banco;
-- Criação da tabela Cliente
CREATE TABLE Cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Criação da tabela Produto
CREATE TABLE Produto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela Pedido
CREATE TABLE Pedido (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    data DATE NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id)
);

-- Criação da tabela ItemPedido
CREATE TABLE ItemPedido (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES Pedido(id),
    FOREIGN KEY (id_produto) REFERENCES Produto(id)
);
