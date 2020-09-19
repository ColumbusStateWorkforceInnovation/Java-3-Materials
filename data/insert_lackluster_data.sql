delete from order_line_items;
delete from orders;
delete from rentals;
delete from customers;
delete from employees;

insert into employees (first_name, last_name, active_store_number) values ('Jim', 'Kirkbride', '39458');
insert into employees (first_name, last_name, active_store_number) values ('Wynter', 'Miller', '39458');

insert into customers (first_name, last_name, smart_id) values ('Max', 'Daniels', '23945809577');
insert into customers (first_name, last_name, smart_id) values ('Leah', 'Williamson', '23845809255');

insert into rentals (name, rental_type, category, year, director, num_available) values ('Aliens', 'dvd', 'action', '1987', 'James Cameron', 20);
insert into rentals (name, rental_type, category, year, director, num_available) values ('Toy Story', 'dvd', 'family', '1994', 'John Lasseter', 50);

insert into orders (employee_id, customer_id, store_number, order_datetime) values(1, 1, '39458', CURRENT_TIME);

insert into order_line_items (order_id, rental_id, due_datetime) values (1, 1, CURDATE() + 3);