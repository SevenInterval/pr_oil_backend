package com.prista.pr_oil_selector.controller.response;

import com.prista.pr_oil_selector.entity.dto.BrandDto;
import com.prista.pr_oil_selector.utility.enums.ResponseStatusType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BrandsResponse extends BaseResponse{
    private List<BrandDto> brandList;

    public BrandsResponse(ResponseStatusType responseStatusType, List<BrandDto> brandList) {
        super(responseStatusType);
        this.brandList = brandList;
    }

    public BrandsResponse(String errorMessage, ResponseStatusType responseStatusType) {
        super(responseStatusType, errorMessage);
    }
}
