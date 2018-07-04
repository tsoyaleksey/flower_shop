package com.flowershop.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(name = "role")
    private String role;
}
