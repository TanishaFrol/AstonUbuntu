
insert into types (title)
values ('T_shirt'),
       ('shorts'),
       ('sundress'),
       ('dress'),
       ('pajamas'),
       ('homeSuit'),
       ('robe'),
       ('shirt'),
       ('trousers');

insert into material (title)
values ('cooler'),
       ('footer'),
       ('viscose'),
       ('velours'),
       ('synthetic');

insert into "size" (title)
values ('42'),
       ('44'),
       ('46'),
       ('48'),
       ('50'),
       ('52'),
       ('54'),
       ('56'),
       ('58');

insert into orders (units, deadlines, type_id, material_id)
values (10, '25-07-2023', 1, 1),
       (8, '25-07-2023', 6, 2),
       (20, '25-07-2023', 5, 4),
       (5, '25-07-2023', 9, 2),
       (15, '25-07-2023', 6, 1),
       (30, '25-07-2023', 7, 4);

insert into orders_sizes (orders_id, sizes_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6),
       (2, 1),
       (2, 3),
       (2, 4),
       (2, 5);
