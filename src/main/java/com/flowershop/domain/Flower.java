package com.flowershop.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "flowers")
public class Flower extends BaseEntity {

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "price")
    private double price;

    @NotEmpty
    @Column(name = "available")
    private int availableFlowers;

    @OneToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @OneToOne
    @JoinColumn(name = "type_id")
    private FlowerType type;

}
