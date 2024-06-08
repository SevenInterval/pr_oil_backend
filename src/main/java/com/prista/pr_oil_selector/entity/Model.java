package com.prista.pr_oil_selector.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "MODEL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "BRAND_ID")
    private String brandId;

    @Column(name = "BRAND_NAME")
    private String brandName;

    @Column(name = "MODEL_ID")
    private String modelId;
}
