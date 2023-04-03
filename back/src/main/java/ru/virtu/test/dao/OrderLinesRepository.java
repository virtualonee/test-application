package ru.virtu.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.virtu.test.models.OrderLine;

@Repository
public interface OrderLinesRepository extends JpaRepository<OrderLine, Long> {
}

