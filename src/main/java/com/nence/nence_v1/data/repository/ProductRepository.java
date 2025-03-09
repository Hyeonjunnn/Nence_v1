package com.nence.nence_v1.data.repository;

import com.nence.nence_v1.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
