package ru.virtu.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.virtu.test.dao.GoodsesRepository;
import ru.virtu.test.models.Goods;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class GoodsService {

    private final GoodsesRepository goodsRepository;

    @Autowired
    public GoodsService(GoodsesRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public List<Goods> findAll() {

        return goodsRepository.findAll();
    }
    

    public Goods findOne(Long id) {
        Optional<Goods> good = goodsRepository.findById(id);
        return good.orElse(null);
    }

    @Transactional
    public void save(Goods good) {
        goodsRepository.save(good);
    }

    @Transactional
    public void update(Long id, Goods updatedGood) {
        updatedGood.setId(id);
        goodsRepository.save(updatedGood);
    }

    @Transactional
    public void delete(Long id) {
        goodsRepository.deleteById(id);
    }
}
