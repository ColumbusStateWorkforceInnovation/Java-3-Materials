update rentals set name = 'Toy Story 2', year = '1999' where name = 'Toy Story';

select * from rentals r where r.name = 'Toy Story 2';

select c.id, c.first_name, c.last_name, o.order_datetime, r.name from customers c
inner join orders o on o.customer_id = c.id
inner join order_line_items oli on oli.order_id = o.id
inner join rentals r on oli.rental_id = r.id;