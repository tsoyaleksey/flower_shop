create table if not exists categories (
  id serial,
  name varchar(100) not null,
  constraint pk_categories primary key (id)
);
create index if not exists idx_categories_id on categories(id);
alter sequence categories_id_seq restart with 100;

create table if not exists baskets (
  id serial,
  flowers_count int not null default 0,
  total_price double precision not null,
  constraint pk_baskets primary key (id)
);
create index if not exists idx_baskets_id on baskets(id);
alter sequence baskets_id_seq restart with 100;

create table if not exists flowers (
  id serial,
  name varchar(100) not null,
  price double precision not null,
  available int not null,
  category_id int not null,
  foreign key (category_id) references categories(id),
  constraint pk_flower primary key (id)
);
create index if not exists idx_flowers_id on flowers(id);
alter sequence flowers_id_seq restart with 100;

create table if not exists flowers_in_baskets (
  basket_id int not null,
  flower_id int not null,
  added_flowers_count int not null,
  foreign key (basket_id) references baskets(id),
  foreign key (flower_id) references flowers(id),
  constraint unique_ids unique (basket_id, flower_id)
);