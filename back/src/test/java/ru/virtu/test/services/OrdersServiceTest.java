package ru.virtu.test.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.virtu.test.dao.OrdersRepository;
import ru.virtu.test.models.OrderGoods;

import java.util.Collections;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class OrdersServiceTest {

    @Mock
    public OrdersRepository ordersRepository;

    public OrdersService ordersService;
    public OrderGoods order;

    OrdersServiceTest(){
        MockitoAnnotations.openMocks(this);
        this.ordersService = new OrdersService(ordersRepository);
    }

    @BeforeEach
    void setUp(){
        this.order = new OrderGoods(1L,"newClient","newAddress", new Date());
    }

    @Test
    void findAll() {
        given(ordersRepository.findAll()).willReturn((Collections.singletonList(this.order)));

        assertThat(ordersService.findAll().get(0).getClient()).isEqualTo("newClient");
    }

    @Test
    void findOne() {
        given(ordersRepository.findById(1L)).willReturn(java.util.Optional.of(this.order));

        assertThat(ordersService.findOne(1L).getClient()).isEqualTo("newClient");
    }

    @Test
    void save() {
        ordersService.save(this.order);

        verify(ordersRepository).save(this.order);
    }

    @Test
    void update() {
        OrderGoods testOrder = order;
        testOrder.setClient("updatedName");

        ordersService.update(testOrder.getId(), testOrder);

        verify(ordersRepository).save(testOrder);
    }

    @Test
    void delete() {
        ordersService.delete(this.order.getId());

        verify(ordersRepository).deleteById(this.order.getId());
    }
}