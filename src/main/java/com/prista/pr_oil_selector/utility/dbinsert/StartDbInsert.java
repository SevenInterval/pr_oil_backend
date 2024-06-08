package com.prista.pr_oil_selector.utility.dbinsert;

import com.prista.pr_oil_selector.entity.*;
import com.prista.pr_oil_selector.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class StartDbInsert {

    @Autowired
    IBrandRepository brandRepository;

    @Autowired
    IModelRepository modelRepository;

    @Autowired
    IVehicleRepository vehicleRepository;

    @Autowired
    IComponentRepository componentRepository;

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IComponentProductRepository componentProductRepository;

    @PostConstruct
    public void init() {
        List<Brand> brandList = new ArrayList<>();
        List<Model> modelList = new ArrayList<>();
        List<Vehicle> vehicleList = new ArrayList<>();
        List<com.prista.pr_oil_selector.entity.Component> componentList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        List<ComponentProduct> componentProductList = new ArrayList<>();
        String[] category1Names = {"Aston Martin", "Audi", "BMW"};
        for (int i = 0; i < category1Names.length; i++) {
            String brandId = generateRandomId();
            Brand brand = new Brand(null, category1Names[i], 1, brandId);
            brandList.add(brand);

            String modelId = generateRandomId();
            String modelName = category1Names[i] + "_model_";
            Model model = new Model(null, modelName + "1", brandId, category1Names[i], modelId);
            modelList.add(model);

            String vehicleId = generateRandomId();
            String vehicleName = model.getModel();
            Vehicle vehicle1 = new Vehicle(null, vehicleName + "1", 2010, 2020, brandId, category1Names[i], modelId, modelName, vehicleId);
            vehicleList.add(vehicle1);

            String componentId = generateRandomId();
            String componentName = "Engine";
            String vehicleComponentVolumes = "Capacity 3,8 litre (Service fill); Filter capacity 0,6 litre";
            com.prista.pr_oil_selector.entity.Component component = new com.prista.pr_oil_selector.entity.Component(null, componentName, "1234", vehicleComponentVolumes,
                    vehicleId, componentId);
            componentList.add(component);

            String componentId2 = generateRandomId();
            String componentName2 = "Transmission, automatic";
            String vehicleComponentVolumes2 = "Capacity 7,5 litre";
            com.prista.pr_oil_selector.entity.Component component2 = new com.prista.pr_oil_selector.entity.Component(null, componentName2, "1234", vehicleComponentVolumes2,
                    vehicleId, componentId2);
            componentList.add(component2);

            String productId = generateRandomId();
            String productName = "Castrol TRANSMAX ATF DEXRON®-VI MERCON® LV Multivehicle";
            String serviceInternals = "Check 15000 km/ 12 months;Change 75000 km/ 60 months";
            String productDesc = "\"Castrol Transmax ATF DEXRON®-VI MERCON® LV Multivehicle</b>, formulated with Smooth Drive Technology™, \" +\n" +
                    "                    \"is a Full Synthetic Technology formulation designed for modern automatic transmissions.\"";
            String productUrl = "https://castrol.com/content/dam/castrol/country-sites/en_gb/united-kingdom/home/car-engine-oils/transmax_atf_dexron_vi_mercon_lv_multivehicle.jpg";
            Product product = new Product(null, productName, productDesc, serviceInternals, productUrl, productId);
            productList.add(product);

            ComponentProduct componentProduct = new ComponentProduct(null, componentId2, productId, "RECOMMENDED");
            componentProductList.add(componentProduct);

            String productId2 = generateRandomId();
            String productName2 = "Castrol TRANSMAX ATF Dex/Merc Multivehicle";
            String serviceInternals2 = "Check 15000 km/ 12 months;Change 75000 km/ 60 months";
            String productDesc2 = "\"Castrol Transmax ATF DEXRON®-VI MERCON® LV Multivehicle</b>, formulated with Smooth Drive Technology™, \" +\n" +
                    "                    \"is a Full Synthetic Technology formulation designed for modern automatic transmissions.\"";
            String productUrl2 = "https://castrol.com/content/dam/castrol/country-sites/en_gb/united-kingdom/home/car-engine-oils/transmax_atf_dex_merc_multivehicle.jpg";
            Product product2 = new Product(null, productName2, productDesc2, serviceInternals2, productUrl2, productId2);
            productList.add(product2);

            ComponentProduct componentProduct2 = new ComponentProduct(null, componentId2, productId2, "ALTERNATE");
            componentProductList.add(componentProduct2);

            String productId3 = generateRandomId();
            String productName3 = "Castrol React DOT 4 Low Temp";
            String serviceInternals3 = "Change 24 months";
            String productDesc3 = "\"Castrol Transmax ATF DEXRON®-VI MERCON® LV Multivehicle</b>, formulated with Smooth Drive Technology™, \" +\n" +
                    "                    \"is a Full Synthetic Technology formulation designed for modern automatic transmissions.\"";
            String productUrl3 = "https://castrol.com/content/dam/castrol/country-sites/en_gb/united-kingdom/home/car-engine-oils/transmax_atf_dex_merc_multivehicle.jpg";
            Product product3 = new Product(null, productName3, productDesc3, serviceInternals3, productUrl3, productId3);
            productList.add(product3);

            ComponentProduct componentProduct3 = new ComponentProduct(null, componentId2, productId3, "ALTERNATE");
            componentProductList.add(componentProduct3);


            vehicleId = generateRandomId();
            Vehicle vehicle2 = new Vehicle(null, vehicleName + "2", 2010, 2020, brandId, category1Names[i], modelId, modelName, vehicleId);
            vehicleList.add(vehicle2);

            modelId = generateRandomId();
            Model model2 = new Model(null, modelName + "2", brandId, category1Names[i], modelId);
            modelList.add(model2);

            vehicleId = generateRandomId();
            vehicleName = model2.getModel();
            Vehicle vehicle3 = new Vehicle(null, vehicleName + "1", 2010, 2020, brandId, category1Names[i], modelId, modelName, vehicleId);
            vehicleId = generateRandomId();
            Vehicle vehicle4 = new Vehicle(null, vehicleName + "2", 2010, 2020, brandId, category1Names[i], modelId, modelName, vehicleId);
            vehicleList.add(vehicle3);
            vehicleList.add(vehicle4);

            modelId = generateRandomId();
            Model model3 = new Model(null, modelName + "3", brandId, category1Names[i], modelId);
            modelList.add(model3);

            vehicleId = generateRandomId();
            vehicleName = model3.getModel();
            Vehicle vehicle5 = new Vehicle(null, vehicleName + "1", 2010, 2020, brandId, category1Names[i], modelId, modelName, vehicleId);
            vehicleId = generateRandomId();
            Vehicle vehicle6 = new Vehicle(null, vehicleName + "2", 2010, 2020, brandId, category1Names[i], modelId, modelName, vehicleId);
            vehicleList.add(vehicle5);
            vehicleList.add(vehicle6);
        }

        brandRepository.saveAll(brandList);
        modelRepository.saveAll(modelList);
        vehicleRepository.saveAll(vehicleList);
        componentRepository.saveAll(componentList);
        productRepository.saveAll(productList);
        componentProductRepository.saveAll(componentProductList);
    }

    private String generateRandomId() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString().replace("-", "");
        return uuidString.substring(0, 16);
    }
}
