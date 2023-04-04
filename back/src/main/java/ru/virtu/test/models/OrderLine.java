package ru.virtu.test.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Order_line")
public class OrderLine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderGoods orderGoods;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    private Goods goods;

    @Column(name = "count")
    private Long count;

    public OrderLine(){

    }

    public OrderLine(OrderGoods orderGoods, Goods goods, Long count) {
        this.orderGoods = orderGoods;
        this.goods = goods;
        this.count = count;
    }

    public OrderLine(Long id, OrderGoods orderGoods, Goods goods, Long count) {
        this.id = id;
        this.orderGoods = orderGoods;
        this.goods = goods;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderGoods getOrder() {
        return orderGoods;
    }

    public void setOrder(OrderGoods orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Goods getGood() {
        return goods;
    }

    public void setGood(Goods goods) {
        this.goods = goods;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return Objects.equals(orderGoods, orderLine.orderGoods) && Objects.equals(goods, orderLine.goods) && Objects.equals(count, orderLine.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderGoods, goods, count);
    }
}
