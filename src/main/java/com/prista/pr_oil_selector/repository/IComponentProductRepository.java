package com.prista.pr_oil_selector.repository;

import com.prista.pr_oil_selector.entity.ComponentProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComponentProductRepository extends JpaRepository<ComponentProduct, Long> {
    List<ComponentProduct> findByComponentId(String componentId);
}
