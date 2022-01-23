package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.model.DishData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishDataRepository extends JpaRepository<DishData, Long> {
    Optional<DishData> findById(Long id);
    List<DishData> findByName(String name);
    List<DishData> findAll();
}