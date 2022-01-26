package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.model.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDataRepository extends JpaRepository<ProductData, Long> {
    Optional<ProductData> findById(Long id);
    List<ProductData> findByName(String name);
}
