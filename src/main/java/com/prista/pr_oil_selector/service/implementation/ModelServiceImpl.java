package com.prista.pr_oil_selector.service.implementation;

import com.prista.pr_oil_selector.entity.Model;
import com.prista.pr_oil_selector.entity.dto.ModelDto;
import com.prista.pr_oil_selector.repository.IModelRepository;
import com.prista.pr_oil_selector.service.IModelService;
import com.prista.pr_oil_selector.utility.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelServiceImpl implements IModelService {

    @Autowired
    IModelRepository repository;

    @Override
    public List<ModelDto> findModelsByBrandId(String brandId) throws GlobalException {
        List<Model> modelList = repository.findByBrandId(brandId);
        if (modelList.isEmpty()) {
            throw new GlobalException("Model is not found for this brandId!");
        }
        List<ModelDto> modelDtoList = new ArrayList<>();
        for (Model model : modelList) {
            ModelDto modelDto = new ModelDto(model.getModelId(), model.getModel(), model.getYearFrom(), model.getYearTo());
            modelDtoList.add(modelDto);
        }
        return modelDtoList;
    }
}
