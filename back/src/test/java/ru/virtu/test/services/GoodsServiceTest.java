package ru.virtu.test.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.virtu.test.dao.GoodsesRepository;
import ru.virtu.test.models.Goods;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class GoodsServiceTest {

    @Mock
    public GoodsesRepository goodsesRepository;

    public GoodsService goodsService;
    public Goods goods;

    GoodsServiceTest(){
        MockitoAnnotations.openMocks(this);
        this.goodsService = new GoodsService(goodsesRepository);
    }

    @BeforeEach
    void setUp(){
        this.goods = new Goods(1L, "goods", 500L);
    }

    @Test
    void findAll() {
        given(goodsesRepository.findAll()).willReturn((Collections.singletonList(this.goods)));

        Goods goods = goodsService.findAll().get(0);

        assertThat(goods.getName()).isEqualTo("goods");
    }

    @Test
    void findOne() {
        given(goodsesRepository.findById(1L)).willReturn(java.util.Optional.of(this.goods));

        Goods goods = goodsService.findOne(1L);

        assertThat(goods.getName()).isEqualTo("goods");
    }

    @Test
    void save() {
        goodsService.save(this.goods);

        verify(goodsesRepository).save(this.goods);
    }

    @Test
    void update() {
        Goods testGoods = goods;
        testGoods.setName("newName");

        goodsService.update(testGoods.getId(), testGoods);

        verify(goodsesRepository).save(testGoods);
    }

    @Test
    void delete() {

        goodsService.delete(this.goods.getId());

        verify(goodsesRepository).deleteById(this.goods.getId());
    }
}