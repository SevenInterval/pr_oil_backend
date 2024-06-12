package com.prista.pr_oil_selector.controller;

import com.prista.pr_oil_selector.controller.response.BaseResponse;
import com.prista.pr_oil_selector.controller.response.RecommendationResponse;
import com.prista.pr_oil_selector.entity.dto.RecommendationDto;
import com.prista.pr_oil_selector.service.IProductService;
import com.prista.pr_oil_selector.utility.enums.ResponseStatusType;
import com.prista.pr_oil_selector.utility.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/pristaoil/recommendations")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping(path = "/vehicleid/{vehicleId}")
    public ResponseEntity<BaseResponse> getRecommendationsByVehicleId(@PathVariable(value = "vehicleId") String vehicleId) {
        try {
            RecommendationDto recommendationDto = productService.findRecommendationsByVehicleId(vehicleId);
            return new ResponseEntity<>(new RecommendationResponse(ResponseStatusType.SUCCESS, recommendationDto), HttpStatus.OK);
        } catch (GlobalException e) {
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL, e.getErrorMessage()), HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL, "Couldn't find a vehicle for this vehicleId"), HttpStatus.BAD_REQUEST);
        }
    }
}
