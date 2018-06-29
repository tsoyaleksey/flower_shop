package com.flowershop.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotEmpty
    @Column(name = "login")
    private String login;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;
}
