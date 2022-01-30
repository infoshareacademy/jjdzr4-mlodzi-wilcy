package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishDataRepository extends JpaRepository<Dish, Long> {
    Optional<Dish> findById(Long id);
    List<Dish> findByName(String name);
    List<Dish> findAll();
}