create table if not exists flowers_types(
  id serial,
  name varchar(100) not null,
  constraint pk_type primary key (id)
);
create index if not exists idx_type_name on flowers_types(name);
alter sequence flowers_types_id_seq restart with 100;

create table if not exists baskets(
  id serial,
  flowers_count int not null default 0,
  total_price double precision not null default 0,
  constraint pk_baskets primary key (id)
);
alter sequence baskets_id_seq restart with 100;

create table if not exists colors(
  id serial,
  name varchar(100) not null,
  constraint pk_colors primary key (id)
);
create index if not exists idx_colors_name on colors(name);
alter sequence colors_id_seq restart with 100;

create table if not exists flowers(
  id serial,
  name varchar(100) not null,
  price double precision not null,
  available int not null,
  color_id int not null,
  type_id int not null,
  foreign key (color_id) references colors(id),
  foreign key (type_id) references flowers_types(id),
  constraint pk_flowers primary key (id)
);
create index if not exists idx_flowers_name on flowers(name);
alter sequence flowers_id_seq restart with 100;

create table if not exists flowers_in_baskets(
  basket_id int not null,
  flower_id int not null,
  foreign key (basket_id) references baskets(id),
  foreign key (flower_id) references flowers(id)
);

create table if not exists roles(
  id serial,
  role varchar(100) not null,
  constraint pk_roles primary key (id)
);

create table if not exists users(
  id serial,
  login varchar(255) not null,
  password varchar(255) not null,
  email varchar(100) not null,
  active boolean not null default true,
  basket_id int not null,
  foreign key (basket_id) references baskets(id),
  constraint pk_users primary key (id)
);
create index if not exists idx_users_login on users(login);
alter sequence users_id_seq restart with 100;

create table if not exists user_role(
  user_id int not null,
  role_id int not null,
  foreign key (user_id) references users(id),
  foreign key (role_id) references roles(id)
);
