package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductDataRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    List<Product> findByName(String name);
}
