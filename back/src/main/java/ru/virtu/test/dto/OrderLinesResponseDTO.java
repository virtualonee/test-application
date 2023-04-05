package ru.virtu.test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderLinesResponseDTO {

    public Long id;
    public Long goodsId;
    public Long orderGoods;
    public Long count;
}
