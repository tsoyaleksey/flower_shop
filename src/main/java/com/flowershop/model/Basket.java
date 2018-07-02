package com.flowershop.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "baskets")
public class Basket extends BaseEntity {

    @NotEmpty
    @Column(name = "flowers_count")
    private int flowersCount;

    @NotEmpty
    @Column(name = "total_price")
    private double totalPrice;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "flowers_in_baskets", joinColumns = @JoinColumn(name = "basket_id"),
                inverseJoinColumns = @JoinColumn(name = "flower_id"))
    private List<Flower> flowersInBasket;

    public void addFlower(Flower flower) {
        flowersInBasket.add(flower);
    }

    public void removeFlower(Flower flower) {
        flowersInBasket.remove(flower);
    }
}
