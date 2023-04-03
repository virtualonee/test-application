DROP TABLE IF EXISTS "Order" CASCADE;
DROP TABLE IF EXISTS Goods CASCADE;
DROP TABLE IF EXISTS Order_line CASCADE;

CREATE TABLE "Order" (
    id BIGINT PRIMARY KEY auto_increment,
    client VARCHAR(100) NOT NULL,
    date DATE,
    address VARCHAR(100) NOT NULL
);

CREATE TABLE Goods (
    id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR(100) NOT NULL,
    price NUMERIC NOT NULL
);

CREATE TABLE Order_line (
    id BIGINT PRIMARY KEY auto_increment,
    order_id BIGINT,
    goods_id BIGINT,
    count BIGINT,
    foreign key (order_id) references "Order"(id),
    foreign key (goods_id) references Goods(id)
);