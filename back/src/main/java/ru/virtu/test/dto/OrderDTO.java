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

}
