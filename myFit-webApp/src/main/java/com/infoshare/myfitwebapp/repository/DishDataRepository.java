package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.entity.Dish;
import com.infoshare.myfitwebapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DishDataRepository extends JpaRepository<Dish, Long> {
    Optional<Dish> findByProduct(Product product);

    @Query("select d from Dish d where d.id = ?1")
    Optional<Dish> findById(Long id);

    @Query("select d from Dish d where d.name like %?1%")
    List<Dish> findByName(String name);

    @Query("select d from Dish d")
    List<Dish> findAll();

}