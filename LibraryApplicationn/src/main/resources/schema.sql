/*create table address
(address_id int primary key auto_increment,
location varchar(40));

create table library
(library_id int primary key auto_increment,
name varchar(40),
address_id int,
foreign key(address_id) references address(address_id));

create table member(
member_id int primary key auto_increment,
member_name varchar(40),
library_id int,
foreign key(library_id) references library(library_id));

create table publisher(
publisher_id int primary key auto_increment,
publisher_name varchar(40));

create table book(
book_id int primary key auto_increment,
book_name varchar(40),
author varchar(40),
price int,
available boolean,
publisher_id int,
foreign key(publisher_id) references publisher(publisher_id));*/



--create table users(username varchar(50) not null primary key,
--password varchar(50) not null,
--enable boolean not null);
--
--
--
--create table authorities(
--username varchar(50) not null,
--authority varchar(50) not null,
--foreign key(username) references users(username)
--);

--create unique index id on authorities(username,authorities);
--insert into users values('user','user',true);
--insert into users values('admin','admin',true);
--insert into authorities values('user','USER');
--INSERT INTO authorities values('admin','admin');
