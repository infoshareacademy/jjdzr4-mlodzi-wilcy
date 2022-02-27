package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DishDataRepository extends JpaRepository<Dish, Long> {
    Optional<Dish> findById(Long id);
    List<Dish> findByName(String name);
    List<Dish> findAll();
}