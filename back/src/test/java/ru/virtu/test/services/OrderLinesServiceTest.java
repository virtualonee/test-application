package ru.virtu.test.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.virtu.test.dao.GoodsesRepository;
import ru.virtu.test.dao.OrderLinesRepository;
import ru.virtu.test.dao.OrdersRepository;
import ru.virtu.test.models.Goods;
import ru.virtu.test.models.OrderGoods;
import ru.virtu.test.models.OrderLine;

import java.util.Collections;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class OrderLinesServiceTest {

    @Mock
    public OrderLinesRepository orderLinesRepository;
    @Mock
    public OrdersRepository ordersRepository;
    @Mock
    public GoodsesRepository goodsesRepository;

    public OrderLinesService orderLinesService;
    public Goods goods;
    public OrderLine orderLine;
    public OrderGoods order;

    OrderLinesServiceTest(){
        MockitoAnnotations.openMocks(this);
        this.orderLinesService = new OrderLinesService(orderLinesRepository, goodsesRepository, ordersRepository);
    }

    @BeforeEach
    void setUp(){
        this.order = new OrderGoods(1L,"newClient","newAddress", new Date());
        this.goods = new Goods(1L, "goods", 500L);
        this.orderLine = new OrderLine(1L, order, goods, 10L);
    }

    @Test
    void findAll() {
        given(orderLinesRepository.findAll()).willReturn((Collections.singletonList(this.orderLine)));

        assertThat(orderLinesRepository.findAll().get(0).getCount()).isEqualTo(10L);
    }

    @Test
    void findOne() {
        given(orderLinesRepository.findById(1L)).willReturn(java.util.Optional.of(this.orderLine));

        assertThat(orderLinesService.findOne(1L).getCount()).isEqualTo(10L);
    }

    @Test
    void save() {
        orderLinesService.save(this.orderLine);

        verify(orderLinesRepository).save(this.orderLine);
    }

    @Test
    void update() {
        OrderLine testOrderLine = orderLine;
        testOrderLine.setCount(100L);

        orderLinesService.update(testOrderLine.getId(), testOrderLine);

        verify(orderLinesRepository).save(testOrderLine);
    }

    @Test
    void delete() {
        orderLinesService.delete(this.orderLine.getId());

        verify(orderLinesRepository).deleteById(this.orderLine.getId());
    }
}