package com.prista.pr_oil_selector.service;

import com.prista.pr_oil_selector.entity.dto.ModelDto;
import com.prista.pr_oil_selector.utility.exception.GlobalException;

import java.util.List;

public interface IModelService {
    List<ModelDto> findModelsByBrandId(String brandId) throws GlobalException;
}
