drop database if exists lackluster_video;
create database lackluster_video;

use lackluster_video;
drop table if exists order_line_items;
drop table if exists orders;
drop table if exists rentals;
drop table if exists customers;
drop table if exists employees;
create table employees (
id INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
active_store_number VARCHAR(30) NOT NULL
);

create table customers (
id INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
smart_id VARCHAR(30) NOT NULL UNIQUE,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL
);

create table rentals (
id INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
rental_type VARCHAR(30) NOT NULL,
category VARCHAR(30) NOT NULL,
year VARCHAR(4) NOT NULL,
director VARCHAR(60),
num_available INT(9) UNSIGNED
);

create table orders (
id INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
employee_id INT(9) UNSIGNED NOT NULL,
customer_id INT(9) UNSIGNED NOT NULL,
store_number VARCHAR(30) NOT NULL,
order_datetime DATETIME NOT NULL
);

create table order_line_items (
id INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
order_id INT(9) UNSIGNED NOT NULL,
rental_id INT(9) UNSIGNED NOT NULL,
due_datetime DATETIME NOT NULL
);

alter table orders add FOREIGN KEY (employee_id) REFERENCES employees(id);
alter table orders add FOREIGN KEY (customer_id) REFERENCES customers(id);
alter table order_line_items add FOREIGN KEY (order_id) REFERENCES orders(id);
alter table order_line_items add FOREIGN KEY (rental_id) REFERENCES rentals(id);