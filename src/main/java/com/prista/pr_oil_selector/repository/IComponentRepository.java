package com.prista.pr_oil_selector.repository;

import com.prista.pr_oil_selector.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComponentRepository extends JpaRepository<Component, Long> {

    List<Component> findByVehicleId(String vehicleId);
}
