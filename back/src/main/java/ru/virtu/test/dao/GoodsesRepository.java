package ru.virtu.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.virtu.test.models.Goods;

import java.util.Optional;

@Repository
public interface GoodsesRepository extends JpaRepository<Goods, Long> {
    Optional<Goods> findByName(String name);
}

