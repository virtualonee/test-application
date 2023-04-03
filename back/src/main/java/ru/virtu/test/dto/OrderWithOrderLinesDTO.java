package ru.virtu.test.dto;

import java.util.Date;
import java.util.List;

public class OrderWithOrderLinesDTO {

    public Long id;
    public String client;
    public String address;
    public Date date;
    public List<OrderLinesDTO> orderLinesDTOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderLinesDTO> getOrderLinesDTOS() {
        return orderLinesDTOS;
    }

    public void setOrderLinesDTOS(List<OrderLinesDTO> orderLinesDTOS) {
        this.orderLinesDTOS = orderLinesDTOS;
    }
}