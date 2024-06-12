package com.prista.pr_oil_selector.entity.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleBean {
    String vehicleId;
    String type;
    int yearFrom;
    int yearTo;
}
