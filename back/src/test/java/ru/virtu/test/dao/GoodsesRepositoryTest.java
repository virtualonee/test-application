package ru.virtu.test.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.virtu.test.models.Goods;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:preload.sql")
@DataJpaTest
class GoodsesRepositoryTest {


    private final GoodsesRepository goodsRepository;
    public Long savedGoodsId;
    public String savedGoodsName;

    @Autowired
    public GoodsesRepositoryTest(GoodsesRepository goodsRepository){
        this.goodsRepository = goodsRepository;
        this.savedGoodsId = -1L;
        this.savedGoodsName = "goods1";
    }

    @Test
    void findAll() {
        assertThat(goodsRepository.findAll()).isNotNull();
    }

    @Test
    void findOne() {
        assertThat(goodsRepository.findById(savedGoodsId).orElse(null)).isNotNull();
    }

    @Test
    void findByName() {
        assertThat(goodsRepository.findByName(savedGoodsName).orElse(null)).isNotNull();
    }

    @Test
    void save() {
        Goods newGoods = goodsRepository.findById(savedGoodsId).orElse(null);
        assertThat(newGoods).isNotNull();

        newGoods.setName("newName");
        newGoods.setId(100L);

        goodsRepository.save(newGoods);
        assertThat(Objects.requireNonNull(goodsRepository.findById(savedGoodsId).orElse(null)).getName()).isEqualTo("newName");
    }

    @Test
    void update() {
        Goods newGoods = goodsRepository.findById(savedGoodsId).orElse(null);
        assertThat(newGoods).isNotNull();

        newGoods.setName("newName");
        newGoods.setId(100L);

        goodsRepository.save(newGoods);
        assertThat(Objects.requireNonNull(goodsRepository.findById(savedGoodsId).orElse(null)).getName()).isEqualTo("newName");
    }

    @Test
    void delete() {
        goodsRepository.deleteById(savedGoodsId);
        assertThat(goodsRepository.findById(savedGoodsId).orElse(null)).isNull();
    }

}