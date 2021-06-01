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
