package com.flowershop.service;

import com.flowershop.domain.Basket;
import com.flowershop.domain.Flower;
import com.flowershop.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    Collection<User> findAllUsers();

    Optional<User> findUserById(int id);

    void save(User user);

    Optional<Basket> findBasketById(int id);

    List<Flower> getAllFlowersInBasket(Basket basket);
}
