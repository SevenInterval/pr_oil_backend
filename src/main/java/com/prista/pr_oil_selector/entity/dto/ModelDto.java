package com.prista.pr_oil_selector.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ModelDto {
    String modelId;
    String model;
    int yearFrom;
    int yearTo;
}
