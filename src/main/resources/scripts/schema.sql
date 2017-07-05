
DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts (
  user_name VARCHAR(20) NOT NULL,
  active    BIT         NOT NULL,
  password  VARCHAR(20) NOT NULL,
  user_role VARCHAR(20) NOT NULL,
  PRIMARY KEY (user_name)
);
DROP TABLE IF EXISTS order_details;
CREATE TABLE order_details (
  id         VARCHAR(50)      NOT NULL,
  amount     DOUBLE PRECISION NOT NULL,
  price      DOUBLE PRECISION NOT NULL,
  quanity    INTEGER          NOT NULL,
  order_id   VARCHAR(50)      NOT NULL,
  product_id VARCHAR(20)      NOT NULL,
  PRIMARY KEY (id)
);
DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
  id               VARCHAR(50)      NOT NULL,
  amount           DOUBLE PRECISION NOT NULL,
  customer_address VARCHAR(255)     NOT NULL,
  customer_email   VARCHAR(128)     NOT NULL,
  customer_name    VARCHAR(255)     NOT NULL,
  customer_phone   VARCHAR(128)     NOT NULL,
  order_date       DATETIME         NOT NULL,
  order_num        INTEGER          NOT NULL,
  PRIMARY KEY (id)
);
DROP TABLE IF EXISTS products;
CREATE TABLE products (
  code        VARCHAR(20)      NOT NULL,
  create_date DATETIME         NOT NULL,
  image       LONGBLOB,
  name        VARCHAR(255)     NOT NULL,
  price       DOUBLE PRECISION NOT NULL,
  PRIMARY KEY (code)
);

ALTER TABLE orders
  ADD UNIQUE (order_num);

ALTER TABLE order_details
  ADD CONSTRAINT order_detail_ord_fk
FOREIGN KEY (order_id)
REFERENCES orders (id);

ALTER TABLE order_details
  ADD CONSTRAINT order_detail_prod_fk
FOREIGN KEY (product_id)
REFERENCES products (code);