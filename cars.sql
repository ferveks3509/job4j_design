create table cars(
    id serial primary key,
    name varchar(255),
    engine_id int references engine(id)
);
create table engine(
    id serial primary key,
    name varchar(255)
);
insert into cars(name) values('opel');
insert into engine(name) values('electric');

create table graphicsСard(
    id serial primary key,
    name varchar(255)
);
create table computer(
    id serial primary key,
    name varchar(255)
);
create table shop(
    id serial primary key;
    computer_name varchar(255) references computer(name),
    graphicsCard_id int references graphicsCard(id)
);
insert into graphicsCard(name) values('nvidia');
insert into computer(name) values('desktop');
insert into shop(computer_name, graphicsCard_id) values('desktop', 1);

create table cpu(
    id serial primary key,
    name varchar(255)
);
create table phone(
    id serial primary key,
    name varchar(255),
    cpu_id int references cpu(id) unique
);


