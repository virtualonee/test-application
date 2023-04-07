package ru.virtu.test.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.virtu.test.models.OrderGoods;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:preload.sql")
@DataJpaTest
class OrdersRepositoryTest {


    private final OrdersRepository ordersRepository;
    public Long savedOrderGoodsId;
    public String savedOrderGoodsClient;

    @Autowired
    public OrdersRepositoryTest(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
        this.savedOrderGoodsId = -1L;
        this.savedOrderGoodsClient= "client1";
    }

    @Test
    void findAll() {
        assertThat(ordersRepository.findAll()).isNotNull();
    }

    @Test
    void findOne() {
        assertThat(ordersRepository.findById(savedOrderGoodsId).orElse(null)).isNotNull();
    }

    @Test
    void findByClient() {
        assertThat(ordersRepository.findByClient(savedOrderGoodsClient).orElse(null)).isNotNull();
    }

    @Test
    void save() {
        OrderGoods newOrder = ordersRepository.findById(savedOrderGoodsId).orElse(null);
        assertThat(newOrder).isNotNull();

        newOrder.setClient("newClient");
        newOrder.setId(100L);

        ordersRepository.save(newOrder);
        assertThat(Objects.requireNonNull(ordersRepository.findById(savedOrderGoodsId).orElse(null)).getClient()).isEqualTo("newClient");
    }

    @Test
    void update() {
        OrderGoods newOrder = ordersRepository.findById(savedOrderGoodsId).orElse(null);
        assertThat(newOrder).isNotNull();

        newOrder.setClient("newClient");

        ordersRepository.save(newOrder);
        assertThat(ordersRepository.findById(savedOrderGoodsId).orElse(null).getClient()).isEqualTo("newClient");
    }

    @Test
    void delete() {
        ordersRepository.deleteById(savedOrderGoodsId);
        assertThat(ordersRepository.findById(savedOrderGoodsId).orElse(null)).isNull();
    }

}