CREATE TABLE disco
 (
	id bigserial NOT NULL,
	nome varchar(255) NULL,
	unique_id uuid NULL,
	genero_id int8 NULL,
	valor float8 NULL,
	CONSTRAINT disco_pkey PRIMARY KEY (id)
);

CREATE TABLE disco_venda (
	id bigserial NOT NULL,
	valor_cashback float8  NULL,
	valor_venda float8 NULL,
	disco_id int8 NULL,
	venda_id int8 NULL,
	CONSTRAINT disco_venda_pkey PRIMARY KEY (id)
);

CREATE TABLE genero (
	id bigserial NOT NULL,
	descricao varchar(255) NULL,
	CONSTRAINT genero_pkey PRIMARY KEY (id)
);

CREATE TABLE genero_cashback (
	id bigserial NOT NULL,
	cashback float8 NULL,
	dia int4 NULL,
	genero_id int8 NULL,
	CONSTRAINT genero_cashback_pkey PRIMARY KEY (id)
);

CREATE TABLE venda (
	id bigserial NOT NULL,
	data_venda timestamp NULL,
	valor_cashback float8 NULL,
	valor_venda float8 NULL,
	CONSTRAINT venda_pkey PRIMARY KEY (id)
);