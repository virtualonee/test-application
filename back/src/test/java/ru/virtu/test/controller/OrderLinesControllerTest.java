package ru.virtu.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.virtu.test.dto.OrderLineDTOTest;
import ru.virtu.test.dto.OrderLinesResponseDTO;
import ru.virtu.test.services.OrderLinesService;

import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderLinesController.class)
class OrderLinesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderLinesService service;

    OrderLineDTOTest orderLineDTOTest;

    MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);

    public OrderLinesControllerTest() {
        this.orderLineDTOTest = new OrderLineDTOTest(1L,1L, 1L);
    }

    @Test
    public void addGoods_Success() throws Exception {
        ObjectMapper Obj = new ObjectMapper();
        String json = Obj.writeValueAsString(orderLineDTOTest);

        this.mockMvc.perform(post("/order_lines/add").accept(MEDIA_TYPE_JSON_UTF8).contentType(MEDIA_TYPE_JSON_UTF8)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());

        verify(service).saveDTO(any());
    }

    @Test
    public void updateGoods_Success() throws Exception {
        OrderLinesResponseDTO orderLinesResponseDTO = new OrderLinesResponseDTO(1L, 1L, 1L, 100L);

        ObjectMapper Obj = new ObjectMapper();
        String json = Obj.writeValueAsString(orderLinesResponseDTO);

        this.mockMvc.perform(put("/order_lines/1/update").accept(MEDIA_TYPE_JSON_UTF8).contentType(MEDIA_TYPE_JSON_UTF8)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk());

        verify(service).saveDTO(any());
    }

    @Test
    public void deleteGoods_Success() throws Exception {
        this.mockMvc.perform(delete("/order_lines/1/delete"))
                .andExpect(status().isOk());

        verify(service).delete(any());
    }

}