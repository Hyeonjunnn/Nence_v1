package com.nence.nence_v1.data.dao;

import com.nence.nence_v1.data.entity.Product;

import java.util.Optional;

public interface ProductDAO {
    Product insertProduct(Product product);

    Optional<Product> selectProduct(Long number);

    Product updateProduct(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
