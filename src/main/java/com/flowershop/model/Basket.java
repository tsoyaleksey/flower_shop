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
    @JoinTable(name = "flowers_in_baskets", joinColumns = @JoinColumn(name = "flower_id"),
                inverseJoinColumns = @JoinColumn(name = "basket_id"))
    private List<Flower> flowersInBasket;

    @OneToOne(mappedBy = "basket", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    private User user;

    public void addFlower(Flower flower) {
        flowersInBasket.add(flower);
        flower.getBaskets().add(this);
    }

    public void removeFlower(Flower flower) {
        flowersInBasket.remove(flower);
        flower.getBaskets().remove(this);
    }
}
