package ru.virtu.test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.virtu.test.dto.GoodsDTO;
import ru.virtu.test.models.Goods;
import ru.virtu.test.services.GoodsService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GoodsController.class)
class GoodsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GoodsService service;

    List<GoodsDTO> goodsDTOList;
    List<Goods> goodsList;

    GoodsDTO goodsDTO;
    Goods goods;

    @BeforeEach
    public void setUp(){
        goodsDTOList = new ArrayList<>();
        goodsDTO = new GoodsDTO(1L, "goodsDTO", 100L);
        goodsDTOList.add(goodsDTO);

        goodsList = new ArrayList<>();
        goods = new Goods("goods", 50L);
        goodsList.add(goods);

    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {

        when(service.findAll()).thenReturn(goodsList);
        this.mockMvc.perform(get("/goods"))
                .andExpect(status().isOk())
                .andExpect(mvcResult -> mvcResult.getResolvedException().getClass().equals(GoodsDTO.class));
    }


}