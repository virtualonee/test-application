package ru.virtu.test.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    public Long id;
    public String client;
    public String address;
    public Date date;

    public OrderDTO(Long id, String client, String address, Date date) {
        this.id = id;
        this.client = client;
        this.address = address;
        this.date = date;
    }
}
