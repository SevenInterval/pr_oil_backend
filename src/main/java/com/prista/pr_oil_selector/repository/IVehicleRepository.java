package com.prista.pr_oil_selector.repository;

import com.prista.pr_oil_selector.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByModelId(String modelId);

    Vehicle findByVehicleId(String vehicleId);
}
