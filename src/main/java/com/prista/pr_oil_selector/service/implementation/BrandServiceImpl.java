package com.prista.pr_oil_selector.service.implementation;

import com.prista.pr_oil_selector.entity.Brand;
import com.prista.pr_oil_selector.entity.dto.BrandDto;
import com.prista.pr_oil_selector.repository.IBrandRepository;
import com.prista.pr_oil_selector.service.IBrandService;
import com.prista.pr_oil_selector.utility.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    IBrandRepository brandRepository;

    @Override
    public List<BrandDto> findBrandsByCategoryId(int categoryId) throws GlobalException {
        List<Brand> brandList = brandRepository.findBrandsByCategoryId(categoryId);
        if (brandList.isEmpty()) {
            throw new GlobalException("Brand is not found for this categoryId!");
        }
        List<BrandDto> brandDtoList = new ArrayList<>();
        for (Brand brand : brandList) {
            BrandDto brandDto = new BrandDto(brand.getBrandId(), brand.getName());
            brandDtoList.add(brandDto);
        }
        return brandDtoList;
    }
}
