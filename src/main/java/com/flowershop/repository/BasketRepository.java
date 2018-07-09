package com.flowershop.repository;

import com.flowershop.domain.Basket;
import com.flowershop.domain.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

    List<Flower> findAllByFlowersInBasket(Basket basket);
}
