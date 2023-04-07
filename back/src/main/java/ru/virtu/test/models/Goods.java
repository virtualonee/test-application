package ru.virtu.test.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name="Goods")
public class Goods {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 100, message = "Name should be from 2 to 100 symbols")
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderLine> orderLines;

    public Goods(String name, Long price){
        this.name = name;
        this.price = price;
    }

    public Goods(Long id, String name, Long price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Goods(Long id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Goods goods = (Goods) o;
        return id != null && Objects.equals(id, goods.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
