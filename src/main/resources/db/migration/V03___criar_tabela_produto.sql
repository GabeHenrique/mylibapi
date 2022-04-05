create table cd_produto (
    id SERIAL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    quantidade BIGINT(20) NOT NULL,
    preco_fabrica DECIMAL NOT NULL,
    preco_venda DECIMAL NOT NULL,
    descricao VARCHAR(255),
    categoria VARCHAR(255),
    considera_estoque BOOLEAN
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
