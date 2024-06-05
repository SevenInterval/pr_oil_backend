package com.prista.pr_oil_selector.entity.bean;

import com.prista.pr_oil_selector.entity.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComponentBean {
    String name;
    String code;
    String[] vehicleComponentVolumes;
    List<ProductDto> alternateProducts;
    ProductDto recommendedProduct;
}
