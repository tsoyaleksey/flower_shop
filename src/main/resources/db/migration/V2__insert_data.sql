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