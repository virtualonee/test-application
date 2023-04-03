package ru.virtu.test.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.virtu.test.dto.OrderDTO;
import ru.virtu.test.dto.OrderLinesDTO;
import ru.virtu.test.dto.OrderWithOrderLinesDTO;
import ru.virtu.test.models.OrderGoods;
import ru.virtu.test.models.OrderLine;
import ru.virtu.test.services.OrdersService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdersController {

    private final OrdersService ordersService;
    private final ModelMapper modelMapper;

    @Autowired
    public OrdersController(OrdersService ordersService, ModelMapper modelMapper) {
        this.ordersService = ordersService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<OrderGoods> getAllOrders() {
        return ordersService.findAll();
    }

    @GetMapping("/{id}/get")
    public OrderWithOrderLinesDTO getOrder(@PathVariable Long id){

        OrderGoods orderGoods = ordersService.findOne(id);

        return convertToOrderWithOrderLinesDTO(orderGoods);
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addOrder(@RequestBody @Valid OrderDTO orderDTO){

        OrderGoods order = convertToOrder(orderDTO);
        ordersService.save(order);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<HttpStatus> updateOrder(@PathVariable Long id, @RequestBody @Valid OrderDTO orderDTO){

        OrderGoods order = convertToOrder(orderDTO);
        ordersService.update(id, order);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}/updateClientData")
    public ResponseEntity<HttpStatus> updateOrdersClientData(@PathVariable Long id, @RequestBody @Valid OrderDTO orderDTO){

        OrderGoods order = convertToOrder(orderDTO);
        ordersService.updateClientData(id, order);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity <HttpStatus> deleteOrder(@PathVariable Long id) {
        ordersService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public OrderGoods convertToOrder(OrderDTO orderDTO){
        return modelMapper.map(orderDTO, OrderGoods.class);
    }

    private OrderDTO convertToOrderDTO(OrderGoods order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    private OrderWithOrderLinesDTO convertToOrderWithOrderLinesDTO(OrderGoods order){

        OrderWithOrderLinesDTO orderWithOrderLinesDTO = new OrderWithOrderLinesDTO();
        List<OrderLinesDTO> orderLinesDTOS = new ArrayList<>();
        OrderLinesDTO lineDTO = new OrderLinesDTO();

        orderWithOrderLinesDTO.setId(order.getId());
        orderWithOrderLinesDTO.setClient(order.getClient());
        orderWithOrderLinesDTO.setAddress(order.getAddress());
        orderWithOrderLinesDTO.setDate(order.getDate());

        for (OrderLine line: order.getOrderLines()) {
            orderLinesDTOS.add(new OrderLinesDTO(line.getId(), line.getGood().getId(),
                    line.getGood().getName(), order.getId(), line.getGood().getPrice(), line.getCount()));
        }

        orderWithOrderLinesDTO.setOrderLinesDTOS(orderLinesDTOS);

        return orderWithOrderLinesDTO;
    }

}
