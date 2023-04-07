INSERT INTO Goods(id, name, price) VALUES (-1, 'goods1', 500);
INSERT INTO Order_goods(id, client, address, date) VALUES (-1, 'client1', 'testAddress1', current_date);
INSERT INTO Order_line(id, order_id, goods_id, count) VALUES (-1, -1, -1, 5)