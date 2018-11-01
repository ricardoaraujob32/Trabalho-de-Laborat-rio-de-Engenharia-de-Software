
-- scripts para criação das tabelas e relacionamentos entre elas

create database pizzaria;
use pizzaria;

CREATE TABLE tbl_cliente (
	id_cliente integer NOT NULL,
	login_cliente char(50),
	senha_cliente char(50),	
	nome_cliente char(50),
	bairro_cliente char(50),
	logradouro_cliente char(50),
	telefone_cliente char(50),
	email_cliente varchar(255),
	PRIMARY KEY (id_cliente)
);

CREATE TABLE tbl_pedido(
	numero_pedido integer NOT NULL,
	id_cliente integer,
	hora_pedido time,
	data_pedido date,
	situacao_pedido char(15),
	PRIMARY KEY (numero_pedido)
);


CREATE TABLE tbl_item_bebida(
	id_item_bebida integer NOT NULL,
	id_bebida integer,
	numero_pedido integer,
	valor_item decimal(5,2),
	PRIMARY KEY (id_item_bebida)
);


CREATE TABLE tbl_bebida(
	id_bebida integer NOT NULL,
	id_tipo_bebida integer,
	descricao_bebida varchar(255),
	PRIMARY KEY (id_bebida)
);


CREATE TABLE tbl_tipo_bebida(
	id_tipo_bebida integer NOT NULL,
	descricao_tipo varchar(255),
	PRIMARY KEY (id_tipo_bebida)
);


CREATE TABLE tbl_sabor(
	id_sabor integer NOT NULL,
	nome_sabor varchar(255),
	valor_sabor decimal(5,2),
	PRIMARY KEY (id_sabor)
);


CREATE TABLE tbl_item_sabor(
	id_item_sabor integer NOT NULL,
	id_pizza integer,
	id_sabor integer,
	PRIMARY KEY (id_item_sabor)
);


CREATE TABLE tbl_pizza(
	id_pizza integer NOT NULL,
	numero_pedido integer,
	id_tamanho integer,
	qtd_sabores_pizza tinyint,
	valor_pizza decimal(5,2),
	PRIMARY KEY (id_pizza)
);


CREATE TABLE tbl_tamanho(
	id_tamanho integer NOT NULL,
	descricao_tamanho char(50),
	num_max_pedacos tinyint,
	qtd_sabores_tamanho tinyint,
	PRIMARY KEY (id_tamanho)
);






-- tbl_pedido-------------------------------

ALTER TABLE tbl_pedido
ADD FOREIGN KEY (id_cliente) REFERENCES tbl_cliente(id_cliente);


-- tbl_item_bebida-------------------------------

ALTER TABLE tbl_item_bebida
ADD FOREIGN KEY (id_bebida) REFERENCES tbl_bebida(id_bebida);

ALTER TABLE tbl_item_bebida
ADD FOREIGN KEY (numero_pedido) REFERENCES tbl_pedido(numero_pedido);


-- tbl_bebida-------------------------------

ALTER TABLE tbl_bebida
ADD FOREIGN KEY (id_tipo_bebida) REFERENCES tbl_tipo_bebida(id_tipo_bebida);




-- tbl_pizza-------------------------------

ALTER TABLE tbl_pizza
ADD FOREIGN KEY (numero_pedido) REFERENCES tbl_pedido(numero_pedido);

ALTER TABLE tbl_pizza
ADD FOREIGN KEY (id_tamanho) REFERENCES tbl_tamanho(id_tamanho);



-- tbl_item_sabor-------------------------------

ALTER TABLE tbl_item_sabor
ADD FOREIGN KEY (id_pizza) REFERENCES tbl_pizza(id_pizza);

ALTER TABLE tbl_item_sabor
ADD FOREIGN KEY (id_sabor) REFERENCES tbl_sabor(id_sabor);
