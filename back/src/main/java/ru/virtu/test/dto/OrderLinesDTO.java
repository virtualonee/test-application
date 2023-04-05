package ru.virtu.test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderLinesDTO {
    public Long id;
    public Long goodsId;
    public String goodsName;
    public Long orderGoods;
    public Long goodsPrice;
    public Long count;

    public OrderLinesDTO(Long id, Long goodsId, String goodsName, Long orderGoods, Long goodsPrice, Long count) {
        this.id = id;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.orderGoods = orderGoods;
        this.goodsPrice = goodsPrice;
        this.count = count;
    }
}
