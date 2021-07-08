create table departments(
id serial primary key,
name varchar(255)
);
create table emploees(
id serial primary key,
name varchar(10),
departments_id int references departments(id)
);
insert into departments(name) values
('manager'),
('dev'),
('architect');
insert into emploees(name, departments_id) values
('kiril', 1),
('ilya', 2),
('maria', 3),
('sergey', null);

--2. Выполнить запросы с left, rigth, full, cross соединениями
select * from departments as d left join emploees as e on d.id=e.departments_id;
select * from emploees as e left join departments as d on e.id=d.id;
select * from departments as d right join emploees as e on d.id=e.departments_id;
select * from emploees as e right join departments as d on e.id=d.id;
select * from emploees as e cross join departments as d;
select * from departments as d cross join emploees as e;
--3. Используя left join найти департаменты, у которых нет работников
select * from emploees as e left join departments as d on e.departments_id=d.id where departments_id is null;
--4. Используя left и right join написать запросы, которые давали бы одинаковый результат.
select e.name, d.name from emploees as e left join departments as d on e.departments_id=d.id;
select e.name, d.name from departments as d right join emploees as e on d.id=e.departments_id;
--Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары
create table teens(
id serial primary key,
name varchar(20),
gender varchar(20)
);
insert into teens(name, gender) values
('ilya','m'),
('kiril','m'),
('vasiliy','m'),
('maria','ж'),
('natali','ж'),
('ksenia','ж');

select m.name as man, f.name as woman from (select * from teens where gender = 'm') as m cross join (select * from teens where gender = 'ж') as f;