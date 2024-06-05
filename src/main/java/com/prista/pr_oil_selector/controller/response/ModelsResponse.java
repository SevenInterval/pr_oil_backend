package com.prista.pr_oil_selector.controller.response;

import com.prista.pr_oil_selector.entity.dto.ModelDto;
import com.prista.pr_oil_selector.utility.enums.ResponseStatusType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ModelsResponse extends BaseResponse{
    private List<ModelDto> modelList;

    public ModelsResponse(ResponseStatusType responseStatusType, List<ModelDto> modelList) {
        super(responseStatusType);
        this.modelList = modelList;
    }

    public ModelsResponse(String errorMessage, ResponseStatusType responseStatusType) {
        super(responseStatusType, errorMessage);
    }
}
