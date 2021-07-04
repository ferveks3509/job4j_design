create table devices(
id serial primary key,
name varchar(255),
price float
);

create table people(
id serial primary key,
name varchar(255)
);

create table device_people(
id serial primary key,
device_id int references devices(id),
people_id int references people(id),
);

insert into devices(name, price) values
('phone', 25.000),
('laptop', 55.500),
('iPhone', 120.050);
insert into people(name) values
('kiril'),
('vasiliy'),
('ilya');

insert into device_people(device_id, people_id) values
(1, 1),
insert into device_people(device_id, people_id) values
(1, 2),
(3, 2);
insert into device_people(device_id, people_id) values
(1, 3),
(2, 3),
(3, 3);

select avg(d.price) from devices as d;
select p.name, avg(d.price) from device_people as dp join people as p on p.id = dp.people_id join devices d on d.id=dp.device_id group by dp.people_id, p.name;
select p.name, avg(d.price) from device_people as dp join people as p on p.id = dp.people_id join devices d on d.id=dp.device_id group by dp.people_id, p.name having avg(d.price) > 5000;