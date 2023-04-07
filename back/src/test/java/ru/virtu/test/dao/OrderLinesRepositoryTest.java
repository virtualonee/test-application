package ru.virtu.test.dao;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.virtu.test.models.OrderLine;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:preload.sql")
@DataJpaTest
class OrderLinesRepositoryTest {

    private final OrderLinesRepository orderLinesRepository;
    private Long savedOrderLineId;

    @Autowired
    public OrderLinesRepositoryTest(OrderLinesRepository orderLinesRepository){
        this.orderLinesRepository = orderLinesRepository;
        this.savedOrderLineId = -1L;
    }

    @Test
    void findAll() {
        assertThat(orderLinesRepository.findAll()).isNotNull();
    }

    @Test
    void findOne() {
        assertThat(orderLinesRepository.findById(savedOrderLineId).orElse(null)).isNotNull();
    }

    @Test
    void save() {
        OrderLine newOrderLine = orderLinesRepository.findById(savedOrderLineId).orElse(null);
        assertThat(newOrderLine).isNotNull();

        newOrderLine.setCount(10L);
        newOrderLine.setId(100L);

        orderLinesRepository.save(newOrderLine);
        assertThat(orderLinesRepository.findById(savedOrderLineId).orElse(null)).isEqualTo(newOrderLine);
    }

    @Test
    void update() {
        OrderLine newOrderLine = orderLinesRepository.findById(savedOrderLineId).orElse(null);
        assertThat(newOrderLine).isNotNull();

        newOrderLine.setCount(10L);

        orderLinesRepository.save(newOrderLine);
        assertThat(Objects.requireNonNull(orderLinesRepository.findById(savedOrderLineId).orElse(null)).getCount()).isEqualTo(newOrderLine.getCount());
    }

    @Test
    void delete() {
        orderLinesRepository.deleteById(savedOrderLineId);
        assertThat(orderLinesRepository.findById(savedOrderLineId).orElse(null)).isNull();
    }

}