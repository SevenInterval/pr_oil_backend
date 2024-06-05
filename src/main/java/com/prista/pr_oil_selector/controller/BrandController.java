package com.prista.pr_oil_selector.controller;

import com.prista.pr_oil_selector.controller.response.BaseResponse;
import com.prista.pr_oil_selector.controller.response.BrandsResponse;
import com.prista.pr_oil_selector.entity.dto.BrandDto;
import com.prista.pr_oil_selector.service.IBrandService;
import com.prista.pr_oil_selector.utility.enums.ResponseStatusType;
import com.prista.pr_oil_selector.utility.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/pristaoil/brand")
public class BrandController {

    @Autowired
    IBrandService brandService;

    @GetMapping(path = "/categoryid/{categoryId}")
    public ResponseEntity<BaseResponse> getBrandsByCategoryId(@PathVariable(value="categoryId") int categoryId) {
        try {
            List<BrandDto> brandList = brandService.findBrandsByCategoryId(categoryId);
            return new ResponseEntity<>(new BrandsResponse(ResponseStatusType.SUCCESS, brandList), HttpStatus.OK);
        } catch (GlobalException e) {
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL, e.getErrorMessage()), HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL, "Couldn't find a brand for this categoryId"), HttpStatus.BAD_REQUEST);
        }
    }

}
