package com.flowershop.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "baskets")
public class Basket extends BaseEntity {

    @Column(name = "flowers_count")
    private int flowersCount;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "flowers_in_baskets",
            joinColumns = @JoinColumn(name = "basket_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "flower_id", referencedColumnName = "id"))
    private List<Flower> flowersInBasket;

    public void addFlower(Flower flower) {
        flowersInBasket.add(flower);
    }

    public void removeFlower(Flower flower) {
        flowersInBasket.remove(flower);
    }
}
