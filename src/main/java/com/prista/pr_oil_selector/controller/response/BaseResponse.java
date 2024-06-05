package com.prista.pr_oil_selector.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.prista.pr_oil_selector.utility.enums.ResponseStatusType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private ResponseStatusType responseStatus;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;

    public BaseResponse(ResponseStatusType responseStatus, String errorMessage) {
        this.responseStatus = responseStatus;
        this.errorMessage = errorMessage;
    }

    public BaseResponse(ResponseStatusType responseStatus) {
        this.responseStatus = responseStatus;
    }
}
