create table product(
id serial primary key,
name varchar(255),
price int,
count int
);

insert into product(name, price, count) values
('eggs', 100, 5),
('milk', 90, 3),
('oil', 140, 1);

create table shop(
id serial primary key,
name varchar(10),
product_id int references product(id)
);

insert into shop(name, product_id) values
('magnit',1),
('paterka',2),
('globus',3);

select * from shop join product p on shop.product_id = p.id;
select s.name, p.name, p.price from shop as s join product as p on s.product_id = p.id;
select s.name as Имя, p.name as Имя_продукта, p.price as Цена from shop as s join product as p on s.product_id = p.id;
select s.name || ' ' || s.id as ИмяId, p.name || ' ' || p.count as Имя_продукта_колл_во, p.price as Цена from shop as s join product as p on s.product_id = p.id;