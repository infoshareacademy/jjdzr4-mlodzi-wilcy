package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface ProductDataRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    List<Product> findByName(String name);
}
