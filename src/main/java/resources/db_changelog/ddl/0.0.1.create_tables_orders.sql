create table types (
  id bigserial primary key,
   title VARCHAR(255)
);

CREATE TABLE material (
  id bigserial primary key,
   title VARCHAR(255)
);

CREATE TABLE size (
  id bigserial primary key,
   title INTEGER NOT NULL
);

CREATE TABLE orders (
  id bigserial primary key,
   units INTEGER NOT NULL,
   deadlines VARCHAR(255),
   type_id BIGINT,
   material_id BIGINT,
   FOREIGN KEY (material_id) REFERENCES material (id),
   FOREIGN KEY (type_id) REFERENCES types (id)
);

CREATE TABLE orders_sizes (
  orders_id BIGINT NOT NULL,
   sizes_id BIGINT NOT NULL,
   PRIMARY KEY (orders_id, sizes_id),
   FOREIGN KEY (orders_id) REFERENCES orders (id),
   FOREIGN KEY (sizes_id) REFERENCES size (id)
);
