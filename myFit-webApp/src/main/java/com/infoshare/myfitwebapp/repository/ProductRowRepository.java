package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.entity.ProductRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRowRepository extends JpaRepository<ProductRow, Long> {
}