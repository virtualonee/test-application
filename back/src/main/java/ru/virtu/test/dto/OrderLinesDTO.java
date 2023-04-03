package ru.virtu.test.dto;

public class OrderLinesDTO {
    public Long id;
    public Long goodsId;
    public String goodsName;
    public Long orderGoods;
    public Long goodsPrice;
    public Long count;

    public OrderLinesDTO() {
    }

    public OrderLinesDTO(Long id, Long goodsId, String goodsName, Long orderGoods, Long goodsPrice, Long count) {
        this.id = id;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.orderGoods = orderGoods;
        this.goodsPrice = goodsPrice;
        this.count = count;
    }

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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(Long orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
