
-- scripts para criaÃ§Ã£o das tabelas e relacionamentos entre elas

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










--populando a tabela--

insert into tbl_tipo_bebida (id_tipo_bebida, descricao_tipo)
VALUES (1,"refri");
insert into tbl_tipo_bebida (id_tipo_bebida, descricao_tipo)
VALUES (2,"cerveja");




insert into tbl_cliente (id_cliente, nome_cliente, bairro_cliente, logradouro_cliente, telefone_cliente, email_cliente, login_cliente) values (19, 'Jeanine Hughman', 'Maracaju', 'Brazil', '542-04-2016', 'jhughmani@de.vu', 'jhughmani');
insert into tbl_cliente (id_cliente, nome_cliente, bairro_cliente, logradouro_cliente, telefone_cliente, email_cliente, login_cliente) values (20, 'Myrah Gierardi', 'Kortowo', 'Poland', '745-07-7797', 'mgierardij@rakuten.co.jp', 'mgierardij');
insert into tbl_cliente (id_cliente, nome_cliente, bairro_cliente, logradouro_cliente, telefone_cliente, email_cliente, login_cliente) values (21, 'Sam Trenoweth', 'Khulm', 'Afghanistan', '742-71-9774', 'strenowethk@prlog.org', 'strenowethk');
insert into tbl_cliente (id_cliente, nome_cliente, bairro_cliente, logradouro_cliente, telefone_cliente, email_cliente, login_cliente) values (22, 'Kirbee Yearn', 'Angus', 'Canada', '556-99-7624', 'kyearnl@unesco.org', 'kyearnl');
insert into tbl_cliente (id_cliente, nome_cliente, bairro_cliente, logradouro_cliente, telefone_cliente, email_cliente, login_cliente) values (23, 'Yolande Matysiak', 'Xinzhuang', 'China', '294-20-7589', 'ymatysiakm@ucoz.com', 'ymatysiakm');
insert into tbl_cliente (id_cliente, nome_cliente, bairro_cliente, logradouro_cliente, telefone_cliente, email_cliente, login_cliente) values (24, 'Wyndham Napoli', 'Golub-Dobrzyń', 'Poland', '363-84-8167', 'wnapolin@huffingtonpost.com', 'wnapolin');
insert into tbl_cliente (id_cliente, nome_cliente, bairro_cliente, logradouro_cliente, telefone_cliente, email_cliente, login_cliente) values (25, 'Aharon Crus', 'Hirakata', 'Japan', '104-91-7970', 'acruso@admin.ch', 'acruso');
insert into tbl_cliente (id_cliente, nome_cliente, bairro_cliente, logradouro_cliente, telefone_cliente, email_cliente, login_cliente) values (26, 'Barbara-anne Alesi', 'Zhishan', 'China', '154-30-9934', 'balesip@scientificamerican.com', 'balesip');
insert into tbl_cliente (id_cliente, nome_cliente, bairro_cliente, logradouro_cliente, telefone_cliente, email_cliente, login_cliente) values (27, 'Shayla Wyre', 'Gaborone', 'Botswana', '724-97-9434', 'swyreq@flavors.me', 'swyreq');
insert into tbl_cliente (id_cliente, nome_cliente, bairro_cliente, logradouro_cliente, telefone_cliente, email_cliente, login_cliente) values (28, 'Ashlie Avramov', 'Kiambu', 'Kenya', '253-37-4786', 'aavramovr@accuweather.com', 'aavramovr');
insert into tbl_cliente (id_cliente, nome_cliente, bairro_cliente, logradouro_cliente, telefone_cliente, email_cliente, login_cliente) values (29, 'Charyl Townshend', 'Wamba', 'Democratic Republic of the Congo', '239-26-4120', 'ctownshends@nyu.edu', 'ctownshends');
insert into tbl_cliente (id_cliente, nome_cliente, bairro_cliente, logradouro_cliente, telefone_cliente, email_cliente, login_cliente) values (30, 'Bern Gricks', 'Colima', 'Costa Rica', '539-29-0922', 'bgrickst@example.com', 'bgrickst');



insert into tbl_bebida (id_bebida, descricao_bebida,valor_bebida, id_tipo_bebida) 
values (1, 'coca', 2, 1);

insert into tbl_bebida (id_bebida, descricao_bebida,valor_bebida, id_tipo_bebida) 
values (1, 'fanta', 2, 1);
insert into tbl_bebida (id_bebida, descricao_bebida,valor_bebida, id_tipo_bebida) 
values (1, 'pepsi', 2, 1);
insert into tbl_bebida (id_bebida, descricao_bebida,valor_bebida, id_tipo_bebida) 
values (1, 'itubaina', 2, 1);


insert into tbl_bebida (id_bebida, descricao_bebida,valor_bebida, id_tipo_bebida) 
values (1, 'SKOL', 5, 2);
insert into tbl_bebida (id_bebida, descricao_bebida,valor_bebida, id_tipo_bebida) 
values (1, 'Bhrama', 5, 2);


insert into tbl_sabor (id_sabor,nome_sabor,valor_sabor) 
values (1, 'MUSSARELA', 20,);
insert into tbl_sabor (id_sabor,nome_sabor,valor_sabor) 
values (2, 'CALABREZA', 20,);
insert into tbl_sabor (id_sabor,nome_sabor,valor_sabor) 
values (3, '4 QUEIJOS', 20,);
insert into tbl_sabor (id_sabor,nome_sabor,valor_sabor) 
values (4, 'PEPERONI', 20,);
insert into tbl_sabor (id_sabor,nome_sabor,valor_sabor) 
values (5, 'FRANCESA', 20,);
insert into tbl_sabor (id_sabor,nome_sabor,valor_sabor) 
values (6, 'BRASILEIRA', 20,);
insert into tbl_sabor (id_sabor,nome_sabor,valor_sabor) 
values (7, 'MODA DA CASA', 20,);



