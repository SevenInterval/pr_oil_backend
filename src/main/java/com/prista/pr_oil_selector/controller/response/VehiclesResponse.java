package com.prista.pr_oil_selector.controller.response;

import com.prista.pr_oil_selector.entity.dto.VehicleDto;
import com.prista.pr_oil_selector.utility.enums.ResponseStatusType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehiclesResponse extends BaseResponse{
    private List<VehicleDto> vehicleList;

    public VehiclesResponse(ResponseStatusType responseStatusType, List<VehicleDto> vehicleList) {
        super(responseStatusType);
        this.vehicleList = vehicleList;
    }

    public VehiclesResponse(String errorMessage, ResponseStatusType responseStatusType) {
        super(responseStatusType, errorMessage);
    }
}
