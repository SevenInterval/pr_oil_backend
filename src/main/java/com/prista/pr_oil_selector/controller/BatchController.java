package com.prista.pr_oil_selector.controller;

import com.prista.pr_oil_selector.controller.response.BaseResponse;
import com.prista.pr_oil_selector.controller.response.BrandsResponse;
import com.prista.pr_oil_selector.entity.dto.BrandDto;
import com.prista.pr_oil_selector.service.IBatchService;
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
@RequestMapping("/rest/pristaoil/batch")
public class BatchController {

    @Autowired
    IBatchService batchService;

    @GetMapping(path = "/{specialKey}/{sheetValue}")
    public ResponseEntity<BaseResponse> createDatabaseAndContents(@PathVariable(value="specialKey") String specialKey, @PathVariable(value="sheetValue") int sheetValue) {
        try {
            if(specialKey.equals("prista_941612_ridvan")) {

            } else {
                return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL, "Hata!"), HttpStatus.BAD_REQUEST);
            }
            batchService.createDatabaseAndContents(sheetValue);
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.SUCCESS, "Başarılı"), HttpStatus.OK);
        } catch (GlobalException e) {
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL, e.getErrorMessage()), HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new BaseResponse(ResponseStatusType.FAIL, "Couldn't find a brand for this categoryId"), HttpStatus.BAD_REQUEST);
        }
    }
}
