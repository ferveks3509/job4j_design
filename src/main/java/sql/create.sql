create table role(
id serial primary key,
description text
);
create table user(
id serial primary key,
name varchar(255),
role_id int references role(id)
);
create table rules(
id serial primary key,
name text
);
create table role_rules(
id serial primary key;
rules_id int references rules(id),
role_id int references role(id)
);
create table state(
id serial primary key,
name text
);
create table category(
id serial primary key,
name text
);
create table item(
id serial primary key,
name_id int references user(id),
category_id int references category(id),
state_id int references state(id)
);
create table comments(
id serial primary key,
name varchar(255),
item_id references item(id)
);
create table attachs(
id serial primary key,
name text,
item_id references item(id)
);