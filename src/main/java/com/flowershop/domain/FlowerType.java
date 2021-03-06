package com.flowershop.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "flowers_types")
public class FlowerType extends BaseEntity {

    @NotEmpty
    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Flower flower;
}
