package com.flowershop.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "colors")
public class Color extends BaseEntity {

    @NotEmpty
    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "color", cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    private Flower flower;
}