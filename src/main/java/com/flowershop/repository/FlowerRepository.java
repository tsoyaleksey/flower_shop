package com.flowershop.repository;

import com.flowershop.domain.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowerRepository extends JpaRepository<Flower, Integer> {

    List<Flower> findByName(String name);

    List<Flower> findByPrice(double price);

    List<Flower> findByColor_Id(int id);

    List<Flower> findByType_Id(int id);
}
