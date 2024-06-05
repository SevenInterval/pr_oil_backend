package com.prista.pr_oil_selector.service.implementation;

import com.prista.pr_oil_selector.entity.Vehicle;
import com.prista.pr_oil_selector.entity.dto.VehicleDto;
import com.prista.pr_oil_selector.repository.IVehicleRepository;
import com.prista.pr_oil_selector.service.IVehicleService;
import com.prista.pr_oil_selector.utility.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    IVehicleRepository vehicleRepository;

    @Override
    public List<VehicleDto> findVehiclesByModelId(String modelId) throws GlobalException {
        List<Vehicle> vehicleList = vehicleRepository.findByModelId(modelId);
        if (vehicleList.isEmpty()) {
            throw new GlobalException("Vehicle is not found for this modelId!");
        }
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            VehicleDto vehicleDto = new VehicleDto(vehicle.getVehicleId(), vehicle.getType(), vehicle.getYearFrom(), vehicle.getYearTo());
            vehicleDtoList.add(vehicleDto);
        }
        return vehicleDtoList;
    }
}
