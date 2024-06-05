package com.prista.pr_oil_selector.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "VEHICLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "YEAR_FROM")
    private int yearFrom;

    @Column(name = "YEAR_TO")
    private int yearTo;

    @Column(name = "BRAND_ID")
    private String brandId;

    @Column(name = "BRAND_NAME")
    private String brandName;

    @Column(name = "MODEL_ID")
    private String modelId;

    @Column(name = "MODEL_NAME")
    private String modelName;

    @Column(name = "VEHICLE_ID")
    private String vehicleId;
}
