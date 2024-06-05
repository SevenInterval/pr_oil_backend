package com.prista.pr_oil_selector.entity.dto;

import com.prista.pr_oil_selector.entity.bean.ComponentBean;
import com.prista.pr_oil_selector.entity.bean.VehicleBean;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecommendationDto {
    VehicleBean vehicle;
    List<ComponentBean> components;
}
