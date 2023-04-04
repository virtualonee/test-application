package ru.virtu.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.virtu.test.models.Goods;
import ru.virtu.test.models.OrderLine;

import java.util.Optional;

@Repository
public interface OrderLinesRepository extends JpaRepository<OrderLine, Long> {
    Optional<OrderLine> findAllByGoods(Goods goods);
}

