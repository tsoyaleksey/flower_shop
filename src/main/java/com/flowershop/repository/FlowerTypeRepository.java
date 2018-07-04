package com.flowershop.repository;

import com.flowershop.domain.FlowerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerTypeRepository extends JpaRepository<FlowerType, Integer> {
}
