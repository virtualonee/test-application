package ru.virtu.test.dto;

import java.util.Date;

public class OrderDTOTest {

    public String client;
    public String address;
    public Date date;

    public OrderDTOTest(String client, String address, Date date) {
        this.client = client;
        this.address = address;
        this.date = date;
    }

}
