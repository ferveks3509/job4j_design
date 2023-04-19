/*one to many*/
create table role(
    id serial primary key,
    name varchar(255)
);
create table users(
    id serial primary key,
    name varchar(255),
    role_id int references role(id)
);
/*many to many*/
create table role(
    id serial primary key,
    name varchar(255),
);
create table rules(
    id serial primary key,
    name varchar(255)
);
create table role_rules(
    id serial primary key,
    role_id int references role(id),
    rules_id int references rules(id)
);
/*many to one*/
create table user(
    id serial primary key,
    name varchar(255)
);
create table item(
    id serial primary key,
    name varchar(255),
    user_id int references user(id)
);
/*one to many*/
create table item(
    id serial primary key,
    name varchar(255)
);
create table comments(
    id serial primary key,
    name varchar(255),
    item_id int references item(id)
);
/*one to many*/
create table item(
    id serial primary key,
    name varchar(255)
);
create table attach(
    id serial primary key,
    name varchar(255),
    item_id int references item(id)
);

