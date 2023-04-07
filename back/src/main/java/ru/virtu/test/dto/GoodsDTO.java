package ru.virtu.test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GoodsDTO {

    private Long id;
    private String name;
    private Long price;

    public GoodsDTO(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
