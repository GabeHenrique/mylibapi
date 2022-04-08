create table cd_categoria (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table cd_produto (
                            id SERIAL PRIMARY KEY AUTO_INCREMENT,
                            nome VARCHAR(150) NOT NULL,
                            quantidade BIGINT(20) NOT NULL,
                            preco_fabrica DECIMAL NOT NULL,
                            preco_venda DECIMAL NOT NULL,
                            descricao VARCHAR(255),
                            categoria BIGINT(20) NOT NULL,
                            considera_estoque BOOLEAN,
                            FOREIGN KEY (categoria) REFERENCES cd_categoria(codigo)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;
