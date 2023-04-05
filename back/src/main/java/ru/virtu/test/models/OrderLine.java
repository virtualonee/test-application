package ru.virtu.test.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="Order_line")
public class OrderLine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ToString.Exclude
    private OrderGoods orderGoods;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    @ToString.Exclude
    private Goods goods;

    @Column(name = "count")
    private Long count;

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
