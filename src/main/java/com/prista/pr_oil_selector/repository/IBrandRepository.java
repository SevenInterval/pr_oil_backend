package com.prista.pr_oil_selector.repository;

import com.prista.pr_oil_selector.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findBrandsByCategoryId(int categoryId);
}
