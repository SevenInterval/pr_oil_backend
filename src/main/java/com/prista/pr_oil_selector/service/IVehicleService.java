package com.prista.pr_oil_selector.service;

import com.prista.pr_oil_selector.entity.dto.VehicleDto;
import com.prista.pr_oil_selector.utility.exception.GlobalException;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> findVehiclesByModelId(String modelId) throws GlobalException;
}
