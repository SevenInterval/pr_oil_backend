package com.prista.pr_oil_selector.service.implementation;

import com.prista.pr_oil_selector.entity.Component;
import com.prista.pr_oil_selector.entity.Product;
import com.prista.pr_oil_selector.entity.Vehicle;
import com.prista.pr_oil_selector.entity.bean.ComponentBean;
import com.prista.pr_oil_selector.entity.bean.VehicleBean;
import com.prista.pr_oil_selector.entity.dto.ProductDto;
import com.prista.pr_oil_selector.entity.dto.RecommendationDto;
import com.prista.pr_oil_selector.repository.IComponentRepository;
import com.prista.pr_oil_selector.repository.IProductRepository;
import com.prista.pr_oil_selector.repository.IVehicleRepository;
import com.prista.pr_oil_selector.service.IProductService;
import com.prista.pr_oil_selector.utility.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductionServiceImpl implements IProductService {

    @Autowired
    IVehicleRepository vehicleRepository;

    @Autowired
    IComponentRepository componentRepository;

    @Autowired
    IProductRepository productRepository;

    @Override
    public RecommendationDto findRecommendationsByVehicleId(String vehicleId) throws GlobalException {
        RecommendationDto recommendationDto = new RecommendationDto();

        Vehicle vehicle = vehicleRepository.findByVehicleId(vehicleId);
        if (vehicle == null) {
            throw new GlobalException("Vehicle is not found for this vehicleId!");
        }
        VehicleBean vehicleBean = new VehicleBean(vehicle.getVehicleId(), vehicle.getType(), vehicle.getYearFrom(), vehicle.getYearTo());

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
            List<Product> componentProductList = productRepository.findByComponentId(component.getComponentId());

            for (Product componentProduct : componentProductList) {
                if (componentProduct.getRecommendationType().equals("RECOMMENDED")) {
                    recommendedProduct = new ProductDto(componentProduct.getProductId(), componentProduct.getName(),
                            componentProduct.getServiceInternals().split(";"));
                }
                else {
                    ProductDto alternateProduct = new ProductDto(componentProduct.getProductId(), componentProduct.getName(),
                            componentProduct.getServiceInternals().split(";"));
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
