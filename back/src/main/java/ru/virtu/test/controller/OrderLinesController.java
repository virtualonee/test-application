package ru.virtu.test.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.virtu.test.dto.OrderLinesResponseDTO;
import ru.virtu.test.services.OrderLinesService;

import javax.validation.Valid;


@RestController
@RequestMapping("/order_lines")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderLinesController {

    private final OrderLinesService orderLinesService;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderLinesController(OrderLinesService orderLinesService, ModelMapper modelMapper) {
        this.orderLinesService = orderLinesService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addOrder(@RequestBody @Valid OrderLinesResponseDTO orderLineDTO){

        orderLinesService.saveDTO(orderLineDTO);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<HttpStatus> updateOrder(@PathVariable Long id, @RequestBody @Valid OrderLinesResponseDTO orderLineDTO){

        orderLinesService.saveDTO(orderLineDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity <HttpStatus> deleteOrder(@PathVariable Long id) {
        orderLinesService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
