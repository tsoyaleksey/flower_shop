insert into flowers_types(id, name)
  values (1,'roses'), (2,'lilies'), (3,'tulips'), (4, 'orchids'), (5, 'tropicals');

insert into colors(id, name)
  values (1, 'white'), (2, 'yellow'), (3, 'blue'), (4, 'pink'), (5, 'red'), (6, 'green');

insert into flowers(id, name, price, available, color_id, type_id)
  values
    (1, 'rose', 5.5, 100, 4, 1),
    (2, 'rose', 4.5, 120, 5, 1),
    (3, 'lilium', 6.40, 10, 5, 2),
    (4, 'lilium', 8.30, 1, 3, 2),
    (5, 'tulip', 3.50, 12, 2, 3),
    (6, 'tulip', 3.50, 20, 5, 3),
    (7, 'orchid', 7.50, 40, 1, 4);

insert into baskets(id)
  values
    (1);

insert into users(id, login, password, email, basket_id)
  values
    (1, 'admin', '$2a$11$6POF6si1xx1hbeD8p3unMu9mzXZDuCZlOBK5ykQcSQxKnxOdkBPYG', 'admin@flowershop.com', 1);

insert into roles(id, role)
  values
    (1, 'ADMIN'),
    (2, 'USER'),
    (3, 'ANONYMOUS');

insert into user_role(user_id, role_id)
  values
    (1,1);