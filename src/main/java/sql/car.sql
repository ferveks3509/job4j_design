create table body(
id serial primary key,
name varchar(50)
);
create table engine(
id serial primary key,
name varchar(50)
);
create table transmission(
id serial primary key,
name varchar(50)
);
create table car(
id serial primary key,
name varchar(255)
body_id int references body(id),
engine_id references engine(id),
transmission_id references(id)
);

insert into body(name) values
('купе'),
('седан'),
('хечбек');
insert into engine(name) values
('gas'),
('electric'),
('disel');
insert into transmission(name) values
('1111'),
('2222'),
('3333');
insert into car(name,body_id,engine_id,transmission_id) values
('приора',1 , 1, 1),
('opel',2 , 2, 2),
('ford',3 , 3, 3);
--1) Вывести список всех машин и все привязанные к ним детали.
select c.name as car_name, b.name as body_name, e.name as engine_name, t.name as transmission_name
from car as c join body as b on c.body_id=b.id join engine as e on c.engine_id=e.id join transmission as t on c.transmission_id=t.id;
--2)Вывести отдельно детали
select b.name as not_use from car as c right join body as b on c.body_id=b.id where c.name is null;
select e.name as not_use from car as c right join engine as e on c.engine_id=e.id where c.name is null;
select t.name as not_use from car as c right join transmission as t on c.transmission_id=t.id where c.name is null;

