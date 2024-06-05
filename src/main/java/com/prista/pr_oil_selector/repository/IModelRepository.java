package com.prista.pr_oil_selector.repository;

import com.prista.pr_oil_selector.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IModelRepository extends JpaRepository<Model, Long> {
    List<Model> findByBrandId(String brandId);
}
