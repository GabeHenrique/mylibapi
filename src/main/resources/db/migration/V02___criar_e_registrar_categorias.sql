create table cd_categoria (
    categoria_id SERIAL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

