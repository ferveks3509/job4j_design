create table type(
id serial primary key,
name varchar(255)
);

create table product(
id serial primary key,
name varchar(255),
type_id int references type(id),
expired_date date,
price int
);
create table type_product(
id serial primary key,
type_id int references type(id),
product_id int references product(id)
);
insert into type(name) values
('сыр'),
('мороженое'),
('молоко');
insert into product(name, type_id, expired_date, price) values
('творожный', 1, '04.06.2021', 300),
('плавленный', 1, '03.06.2021', 100),
('косичка', 1, '02.06.2021', 250),
('мальвина', 2, '03.07.2021', 150),
('шоколадное', 2, '04.07.2021', 50),
('премиум', 2, '03.07.2021', 350),
('вятушка', 3, '02.07.2021', 350),
('местное', 3, '03.07.2021', 350),
('неместное', 3, '04.07.2021', 350);
--1. Написать запрос получение всех продуктов с типом "СЫР"
select p.name from product as p join type as t on p.type_id=t.id where t.name like '%сыр%';
--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select p.name from product as p join type as t on p.type_id=t.id where t.name like '%мороженое%';
--3. Написать запрос, который выводит все продукты, срок годности которых уже истек
select p.name from product as p join type as t on p.type_id=t.id where p.expired_date < '07.07.2021';
--4. Написать запрос, который выводит самый дорогой продукт.
select p.name, max(p.price) from product as p join type as t on p.type_id=t.id group by p.name, p.price having max(p.price) >= 350;
--5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество
select t.name, count(p.type_id) from product as p join type as t on p.type_id=t.id group by t."name";
--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select t.name, p.name from product as p join type as t on p.type_id=t.id where t.name ='сыр' or t.name = 'молоко';
--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select t.name, count(p.type_id) from type as t join product as p on t.id=p.type_id group by t.name having (count(p.type_id) < 10);
--8. Вывести все продукты и их тип.
select p.name, t.name from type as t join product as p on t.id=p.type_id;