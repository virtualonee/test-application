package ru.virtu.test.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    @JsonIgnore
    private List<OrderLine> orderLines;

    public OrderGoods(){

    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderGoods orderGoods = (OrderGoods) o;
        return Objects.equals(client, orderGoods.client) && Objects.equals(date, orderGoods.date) && Objects.equals(address, orderGoods.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, date, address);
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", orderLines=" + orderLines +
                '}';
    }
}
