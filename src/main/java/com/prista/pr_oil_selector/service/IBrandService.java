package com.prista.pr_oil_selector.service;

import com.prista.pr_oil_selector.entity.dto.BrandDto;
import com.prista.pr_oil_selector.utility.exception.GlobalException;

import java.util.List;

public interface IBrandService {
    List<BrandDto> findBrandsByCategoryId(int categoryId) throws GlobalException;
}
