package com.prista.pr_oil_selector.service.implementation;

import com.prista.pr_oil_selector.entity.Component;
import com.prista.pr_oil_selector.entity.ComponentProduct;
import com.prista.pr_oil_selector.entity.Product;
import com.prista.pr_oil_selector.entity.Vehicle;
import com.prista.pr_oil_selector.entity.bean.ComponentBean;
import com.prista.pr_oil_selector.entity.bean.VehicleBean;
import com.prista.pr_oil_selector.entity.dto.ProductDto;
import com.prista.pr_oil_selector.entity.dto.RecommendationDto;
import com.prista.pr_oil_selector.repository.IComponentProductRepository;
import com.prista.pr_oil_selector.repository.IComponentRepository;
import com.prista.pr_oil_selector.repository.IProductRepository;
import com.prista.pr_oil_selector.repository.IVehicleRepository;
import com.prista.pr_oil_selector.service.IRecommendationService;
import com.prista.pr_oil_selector.utility.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements IRecommendationService {

    @Autowired
    IVehicleRepository vehicleRepository;

    @Autowired
    IComponentRepository componentRepository;

    @Autowired
    IComponentProductRepository componentProductRepository;

    @Autowired
    IProductRepository productRepository;

    @Override
    public RecommendationDto findRecommendationsByVehicleId(String vehicleId) throws GlobalException {
        RecommendationDto recommendationDto = new RecommendationDto();

        Vehicle vehicle = vehicleRepository.findByVehicleId(vehicleId);
        if (vehicle == null) {
            throw new GlobalException("Vehicle is not found for this vehicleId!");
        }
        VehicleBean vehicleBean = new VehicleBean(vehicle.getVehicleId(), vehicle.getBrandName(), vehicle.getModelName(),
                vehicle.getType(), vehicle.getYearFrom(), vehicle.getYearTo());

        recommendationDto.setVehicle(vehicleBean);

        List<Component> componentList = componentRepository.findByVehicleId(vehicleId);

        List<ComponentBean> componentBeanList = new ArrayList<>();
        for (Component component : componentList) {
            ComponentBean componentBean = new ComponentBean();
            componentBean.setName(component.getName());
            componentBean.setCode(component.getCode());
            componentBean.setVehicleComponentVolumes(component.getVolumes().split(";"));

            List<ProductDto> alternateProductList = new ArrayList<>();
            ProductDto recommendedProduct = null;
            List<ComponentProduct> componentProductList = componentProductRepository.findByComponentId(component.getComponentId());

            for (ComponentProduct componentProduct : componentProductList) {
                Product product = productRepository.findByProductId(componentProduct.getProductId());
                if (componentProduct.getRecommendationType().equals("RECOMMENDED")) {
                    recommendedProduct = new ProductDto(product.getProductId(), product.getName(), product.getDescription(), product.getServiceInternals().split(";"),
                            product.getUrl());
                }
                else {
                    ProductDto alternateProduct = new ProductDto(product.getProductId(), product.getName(), product.getDescription(), product.getServiceInternals().split(";"),
                            product.getUrl());
                    alternateProductList.add(alternateProduct);
                }
            }
            componentBean.setRecommendedProduct(recommendedProduct);
            componentBean.setAlternateProducts(alternateProductList);
            componentBeanList.add(componentBean);
        }
        recommendationDto.setComponents(componentBeanList);
        return recommendationDto;
    }
}
