package ru.virtu.test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderWithOrderLinesDTO {

    public Long id;
    public String client;
    public String address;
    public Date date;
    public List<OrderLinesDTO> orderLinesDTOS;

}