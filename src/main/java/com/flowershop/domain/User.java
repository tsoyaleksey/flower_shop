package com.flowershop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

    @NotBlank(message = "Login cannot be empty")
    @Column(name = "login")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @NotNull
    @Column(name = "active")
    private boolean isEnabled;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id", nullable = false, unique = true)
    private Basket basket;

    @JsonIgnore
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
