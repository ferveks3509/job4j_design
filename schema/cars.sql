create table car_bodies(
    id serial primary key,
    name varchar(200)
);
create table car_engine(
    id serial primary key,
    name varchar(200)
);
create table car_transmission(
    id serial primary key,
    name varchar(200)
);
create table cars(
    id serial primary key,
    name varchar(200),
    body_id int references car_bodies(id),
    engine_id int references car_engine(id),
    transmission_id int references car_transmission(id)
);


select c.name, ct.name, ce.name, cb.name from cars c left join car_transmission ct on c.transmission_id = ct.id
left join car_engine ce on c.engine_id = ce.id
left join car_bodies cb on c.body_id = cb.id;
select cb.name from car_bodies cb left join cars c on cb.id = c.body_id where c.body_id is null;
select ce.name from car_engine ce left join cars c on ce.id = c.engine_id where c.engine_id is null;