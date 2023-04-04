package ru.virtu.test.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.virtu.test.models.Goods;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
class GoodsesRepositoryTest {


    private final GoodsesRepository goodsRepository;
    public Goods savedGoods;

    @Autowired
    public GoodsesRepositoryTest(GoodsesRepository goodsRepository){
        this.goodsRepository = goodsRepository;
    }

    @BeforeEach
    void createRecord(){
        Goods goods = new Goods("goods1", 500l);

        goodsRepository.save(goods);
        this.savedGoods = goods;
    }

    @AfterEach
    void clear(){
        goodsRepository.deleteAll();
    }

    @Test
    void findAll() {
        List<Goods> goods = goodsRepository.findAll();
        Assertions.assertEquals(goods.get(0), savedGoods);
    }

    @Test
    void findOne() {
        Optional<Goods> goods = goodsRepository.findById(savedGoods.getId());
        Assertions.assertEquals(goods.orElse(null), savedGoods);
    }

    @Test
    void findByName() {
        Optional<Goods> goods = goodsRepository.findByName(savedGoods.getName());
        Assertions.assertEquals(goods.orElse(null), savedGoods);
    }

    @Test
    void save() {
        Goods goods = new Goods("newName", 100l);
        goodsRepository.save(goods);
        Assertions.assertEquals(goodsRepository.findByName("newName").orElse(null), goods);
    }

    @Test
    void update() {
        Assertions.assertEquals(savedGoods.getName(), "goods1");

        savedGoods.setName("newName");
        goodsRepository.save(savedGoods);

        Assertions.assertEquals(goodsRepository.findByName("newName").orElse(null), savedGoods);
    }

    @Test
    void delete() {
        goodsRepository.delete(savedGoods);
        Assertions.assertFalse(goodsRepository.findById(savedGoods.getId()).isPresent());
    }

}