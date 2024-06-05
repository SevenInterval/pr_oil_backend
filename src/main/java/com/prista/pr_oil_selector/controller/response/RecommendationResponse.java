package com.prista.pr_oil_selector.controller.response;

import com.prista.pr_oil_selector.entity.dto.RecommendationDto;
import com.prista.pr_oil_selector.utility.enums.ResponseStatusType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommendationResponse extends BaseResponse{
    private RecommendationDto recommendationDto;

    public RecommendationResponse(ResponseStatusType responseStatusType, RecommendationDto recommendationDto) {
        super(responseStatusType);
        this.recommendationDto = recommendationDto;
    }
}
