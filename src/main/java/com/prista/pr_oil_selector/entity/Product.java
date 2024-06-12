package com.prista.pr_oil_selector.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SERVICE_INTERNALS")
    private String serviceInternals;

    @Column(name = "RECOMMENDATION_TYPE")
    private String recommendationType;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "COMPONENT_ID")
    private String componentId;

    @Column(name = "VEHICLE_ID")
    private String vehicleId;
}
