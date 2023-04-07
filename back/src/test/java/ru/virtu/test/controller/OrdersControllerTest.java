package ru.virtu.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.virtu.test.dto.OrderDTO;
import ru.virtu.test.dto.OrderDTOTest;
import ru.virtu.test.models.OrderGoods;
import ru.virtu.test.services.OrdersService;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrdersController.class)
class OrdersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrdersService service;

    List<OrderGoods> orderList;
    OrderGoods order;

    OrderDTOTest orderDTOTest;

    MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);

    public OrdersControllerTest() {
        this.order = new OrderGoods(1L,"newClient","newAddress", new Date(), new ArrayList<>());
        this.orderList = Collections.singletonList(order);

        this. orderDTOTest = new OrderDTOTest("newClient","newAddress", new Date());
    }

    @Test
    public void getAllOrders_Success() throws Exception {

        when(service.findAll()).thenReturn(orderList);
        this.mockMvc.perform(get("/order"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].client").value("newClient"))
                .andExpect(jsonPath("$[0].address").value("newAddress"));
    }

    @Test
    public void getOrder_Success() throws Exception {
        when(service.findOne(1L)).thenReturn(order);
        this.mockMvc.perform(get("/order/1/get"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.client").value("newClient"))
                .andExpect(jsonPath("$.address").value("newAddress"));
    }

    @Test
    public void addOrder_Success() throws Exception {
        ObjectMapper Obj = new ObjectMapper();
        String json = Obj.writeValueAsString(orderDTOTest);

        this.mockMvc.perform(post("/order/add").accept(MEDIA_TYPE_JSON_UTF8).contentType(MEDIA_TYPE_JSON_UTF8)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());

        verify(service).save(any());
    }

    @Test
    public void updateOrder_Success() throws Exception {
        OrderDTO goods = new OrderDTO(1L,"newClient","newAddress", new Date());

        ObjectMapper Obj = new ObjectMapper();
        String json = Obj.writeValueAsString(goods);

        this.mockMvc.perform(put("/order/1/update").accept(MEDIA_TYPE_JSON_UTF8).contentType(MEDIA_TYPE_JSON_UTF8)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk());

        verify(service).update(any(),any());
    }

    @Test
    public void deleteOrder_Success() throws Exception {
        this.mockMvc.perform(delete("/order/1/delete"))
                .andExpect(status().isOk());

        verify(service).delete(any());
    }
}