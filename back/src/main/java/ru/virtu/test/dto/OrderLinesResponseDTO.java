package ru.virtu.test.dto;

public class OrderLinesResponseDTO {

    public Long id;
    public Long goodsId;
    public Long orderGoods;
    public Long count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(Long orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
