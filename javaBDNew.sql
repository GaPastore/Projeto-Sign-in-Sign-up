#create database javadb;
use javadb;
create table usuario (
	
	id int primary key auto_increment,
    nomeUsuario varchar(50),
    emailUsuario varchar(50),
	senhaUsuario varchar(50)    
    );
    
select * from usuario;