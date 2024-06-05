package com.prista.pr_oil_selector.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "COMPONENT_PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComponentProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COMPONENT_ID")
    private String componentId;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "RECOMMENDATION_TYPE")
    private String recommendationType;
}
