package ru.virtu.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.virtu.test.dao.GoodsesRepository;
import ru.virtu.test.dao.OrderLinesRepository;
import ru.virtu.test.dao.OrdersRepository;
import ru.virtu.test.dto.OrderLinesResponseDTO;
import ru.virtu.test.models.OrderLine;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class OrderLinesService {

    private final OrderLinesRepository orderLinesRepository;
    private final GoodsesRepository goodsesRepository;
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrderLinesService(OrderLinesRepository orderLinesRepository, GoodsesRepository goodsesRepository, OrdersRepository ordersRepository) {
        this.orderLinesRepository = orderLinesRepository;
        this.goodsesRepository = goodsesRepository;
        this.ordersRepository = ordersRepository;
    }

    public List<OrderLine> findAll() {
        return orderLinesRepository.findAll();
    }
    

    public OrderLine findOne(Long id) {
        Optional<OrderLine> orderLine = orderLinesRepository.findById(id);
        return orderLine.orElse(null);
    }

    @Transactional
    public void save(OrderLine orderLine) {
        orderLinesRepository.save(orderLine);
    }

    @Transactional
    public void saveDTO(OrderLinesResponseDTO orderLinesDTO){
        OrderLine orderLine = convertToOrderLine(orderLinesDTO);
        orderLinesRepository.save(orderLine);
    }

    @Transactional
    public void update(Long id, OrderLine updatedOrderLine) {
        updatedOrderLine.setId(id);
        orderLinesRepository.save(updatedOrderLine);
    }

    @Transactional
    public void updateDTO(Long id, OrderLinesResponseDTO orderLinesDTO) {
    }

    @Transactional
    public void delete(Long id) {
        orderLinesRepository.deleteById(id);
    }

    public OrderLine convertToOrderLine(OrderLinesResponseDTO orderLinesResponseDTO){

        OrderLine orderLine = new OrderLine(orderLinesResponseDTO.getId(), ordersRepository.findById(orderLinesResponseDTO.getOrderGoods()).get(),
                goodsesRepository.findById(orderLinesResponseDTO.getGoodsId()).get(), orderLinesResponseDTO.getCount());
        return orderLine;
    }

    private OrderLinesResponseDTO convertToOrderLineDTO(OrderLine order) {

        return null;
    }
}
