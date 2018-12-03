mysql -u root;
create database test1 default character set utf8mb4 collate utf8mb4_general_ci;
use test1;
create table user(
    id int UNSIGNED NOT NUll AUTO_INCREMENT,
    name varchar(200) NOT NUll,
    token text,
    PRIMARY KEY(id)
);