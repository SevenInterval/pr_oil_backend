package com.prista.pr_oil_selector.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "COMPONENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "VOLUMES")
    private String volumes;

    @Column(name = "VEHICLE_ID")
    private String vehicleId;

    @Column(name = "COMPONENT_ID")
    private String componentId;
}
