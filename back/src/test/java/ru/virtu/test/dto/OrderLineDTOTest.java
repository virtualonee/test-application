package ru.virtu.test.dto;

public class OrderLineDTOTest {

    public Long goodsId;
    public Long orderGoods;
    public Long count;

    public OrderLineDTOTest(Long goodsId, Long orderGoods, Long count) {
        this.goodsId = goodsId;
        this.orderGoods = orderGoods;
        this.count = count;
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
