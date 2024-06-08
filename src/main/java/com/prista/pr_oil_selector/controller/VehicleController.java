package com.prista.pr_oil_selector.controller;

import com.prista.pr_oil_selector.controller.response.BaseResponse;
import com.prista.pr_oil_selector.controller.response.VehiclesResponse;
import com.prista.pr_oil_selector.entity.dto.VehicleDto;
import com.prista.pr_oil_selector.service.IVehicleService;
import com.prista.pr_oil_selector.utility.enums.ResponseStatusType;
import com.prista.pr_oil_selector.utility.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/pristaoil/vehicle")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VehicleController {

    @Autowired
    IVehicleService vehicleService;

    @GetMapping(path = "/modelid/{modelId}")
    public ResponseEntity<BaseResponse> getVehiclesByModelId(@PathVariable(value = "modelId") String modelId) {
        try {
            List<VehicleDto> vehicleList = vehicleService.findVehiclesByModelId(modelId);
            return new ResponseEntity<>(new VehiclesResponse(ResponseStatusType.SUCCESS, vehicleList), HttpStatus.OK);
        } catch (GlobalException e) {
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL, e.getErrorMessage()), HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL, "Couldn't find a vehicle for this modelId"), HttpStatus.BAD_REQUEST);
        }
    }

}
