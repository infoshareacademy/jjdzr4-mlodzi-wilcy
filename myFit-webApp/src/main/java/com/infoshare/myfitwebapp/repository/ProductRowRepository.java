package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.entity.DishProductRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRowRepository extends JpaRepository<DishProductRow, Long> {
}