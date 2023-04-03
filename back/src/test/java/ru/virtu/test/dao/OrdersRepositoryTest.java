package ru.virtu.test.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.virtu.test.models.OrderGoods;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
class OrdersRepositoryTest {


    private final OrdersRepository ordersRepository;
    private final GoodsesRepository goodsRepository;
    public OrderGoods savedOrderGoods;

    @Autowired
    public OrdersRepositoryTest(OrdersRepository ordersRepository, GoodsesRepository goodsesRepository){
        this.ordersRepository = ordersRepository;
        this.goodsRepository = goodsesRepository;
    }

    @BeforeEach
    void createRecord(){
        OrderGoods order = new OrderGoods("client1", "testAddress1", new Date());

        ordersRepository.save(order);
        this.savedOrderGoods = order;
    }

    @AfterEach
    void clear(){
        ordersRepository.deleteAll();
    }

    @Test
    void findAll() {
        List<OrderGoods> order = ordersRepository.findAll();
        Assertions.assertEquals(order.get(0), savedOrderGoods);
    }

    @Test
    void findOne() {
        Optional<OrderGoods> order = ordersRepository.findById(savedOrderGoods.getId());
        Assertions.assertEquals(order.get(), savedOrderGoods);
    }

    @Test
    void findByClient() {
        Optional<OrderGoods> order = ordersRepository.findByClient(savedOrderGoods.getClient());
        Assertions.assertEquals(order.get(), savedOrderGoods);
    }

    @Test
    void save() {
        OrderGoods order = new OrderGoods("client2", "testAddress2", new Date());
        ordersRepository.save(order);
        Assertions.assertEquals(ordersRepository.findByClient("client2").get(), order);
    }

    @Test
    void update() {
        Assertions.assertEquals(savedOrderGoods.getClient(), "client1");

        savedOrderGoods.setClient("newName");
        ordersRepository.save(savedOrderGoods);

        Assertions.assertEquals(ordersRepository.findByClient("newName").get(), savedOrderGoods);
    }

    @Test
    void delete() {
        ordersRepository.delete(savedOrderGoods);
        Assertions.assertFalse(ordersRepository.findById(savedOrderGoods.getId()).isPresent());
    }

}