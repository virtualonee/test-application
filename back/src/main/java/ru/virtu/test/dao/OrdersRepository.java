package ru.virtu.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.virtu.test.models.OrderGoods;

import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<OrderGoods, Long> {
    Optional<OrderGoods> findByClient(String client);
}

