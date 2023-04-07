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

    public OrderLinesResponseDTO(Long id, Long goodsId, Long orderGoods, Long count) {
        this.id = id;
        this.goodsId = goodsId;
        this.orderGoods = orderGoods;
        this.count = count;
    }
}
