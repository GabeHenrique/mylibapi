create table cd_usuario (
                            id SERIAL PRIMARY KEY AUTO_INCREMENT,
                            nome VARCHAR(150) NOT NULL,
                            email VARCHAR(150) NOT NULL,
                            senha VARCHAR(12) NOT NULL,
                            telefone VARCHAR(15) NOT NULL,
                            nivel_acesso INTEGER NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
