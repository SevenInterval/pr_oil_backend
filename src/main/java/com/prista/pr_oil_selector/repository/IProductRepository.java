package com.prista.pr_oil_selector.repository;

import com.prista.pr_oil_selector.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Product findByProductId(String productId);
}
