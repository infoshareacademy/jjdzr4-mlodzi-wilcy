package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.id = ?1")
    Optional<Product> findById(Long id);

    @Query("select p from Product p where p.name like %?1%")
    List<Product> findByName(String name);

}
