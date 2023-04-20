create table type(
    id serial primary key,
    name varchar(200)
);
create table product(
    id serial primary key,
    name varchar(50),
    type_id int references type(id),
    expired_date date,
    price int
);
/*запрос на продукты с типом сыр*/
select * from product p join type t on p.type_id = t.id where t.name = 'сыр';
/*запрос получения всех продуктов, у кого в имени есть слово "мороженое"*/
select * from product where product.name like '%мороженое%';
/*запрос который выводит все продукты, срок годности которых уже истек*/
select * from product where product.expired_date > '10.06.2021';
/*запрос который выводит самый дорогой продукт*/
select p.name, max(p.price) from product p group by p.name;
/*запрос который выводит для каждого типа количество продуктов к нему принадлежащих*/
select t.name, count(p) from type t join product p on t.id = p.type_id group by t.name;
/*Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"*/
select * from  product p join type t on p.type_id = t.id where t.name = 'сыр' or t.name = 'молоко';
