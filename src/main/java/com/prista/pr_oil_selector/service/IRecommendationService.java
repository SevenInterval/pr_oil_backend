package com.prista.pr_oil_selector.service;

import com.prista.pr_oil_selector.entity.dto.RecommendationDto;
import com.prista.pr_oil_selector.utility.exception.GlobalException;

public interface IRecommendationService {
    RecommendationDto findRecommendationsByVehicleId(String vehicleId) throws GlobalException;
}
