package ru.virtu.test.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="Order_goods")
public class OrderGoods {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 100, message = "Client should be from 2 to 100 symbols")
    @Column(name = "client")
    private String client;

    @Size(min = 2, max = 100, message = "Address be from 2 to 100 symbols")
    @Column(name = "address")
    private String address;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "orderGoods", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderLine> orderLines;

    public OrderGoods(String client, String address, Date date){
        this.client = client;
        this.address = address;
        this.date = date;
    }

    public OrderGoods(String client, String address, Date date, List<OrderLine> orderLines){
        this.client = client;
        this.address = address;
        this.date = date;
        this.orderLines = orderLines;
    }

    public OrderGoods(Long id, String client, String address, Date date, List<OrderLine> orderLines){
        this.id = id;
        this.client = client;
        this.address = address;
        this.date = date;
        this.orderLines = orderLines;
    }

    public OrderGoods(Long id, String client, String address, Date date){
        this.id = id;
        this.client = client;
        this.address = address;
        this.date = date;
    }

    public OrderGoods(Long id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderGoods that = (OrderGoods) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
