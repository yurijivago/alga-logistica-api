create table cliente(
	id bigint not null auto_increment,
	nome varchar(60) not null,
	email varchar(255),
	telefone varchar(20) not null,
	
	primary key(id)
);