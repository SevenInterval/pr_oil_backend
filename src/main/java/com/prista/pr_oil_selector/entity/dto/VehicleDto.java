package com.prista.pr_oil_selector.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleDto {
    String vehicleId;
    String type;
    int yearFrom;
    int yearTo;
}
