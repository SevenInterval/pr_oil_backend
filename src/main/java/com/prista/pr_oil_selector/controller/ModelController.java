package com.prista.pr_oil_selector.controller;

import com.prista.pr_oil_selector.controller.response.BaseResponse;
import com.prista.pr_oil_selector.controller.response.ModelsResponse;
import com.prista.pr_oil_selector.entity.dto.ModelDto;
import com.prista.pr_oil_selector.service.IModelService;
import com.prista.pr_oil_selector.utility.enums.ResponseStatusType;
import com.prista.pr_oil_selector.utility.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/pristaoil/model")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ModelController {

    @Autowired
    IModelService modelService;

    @GetMapping(path = "/brandid/{brandId}")
    public ResponseEntity<BaseResponse> getModelsByBrandId(@PathVariable(value = "brandId") String brandId) {
        try {
            List<ModelDto> modelList = modelService.findModelsByBrandId(brandId);
            return new ResponseEntity<>(new ModelsResponse(ResponseStatusType.SUCCESS, modelList), HttpStatus.OK);
        } catch (GlobalException e) {
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL, e.getErrorMessage()), HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL, "Couldn't find a model for this brandId"), HttpStatus.BAD_REQUEST);
        }
    }

}
