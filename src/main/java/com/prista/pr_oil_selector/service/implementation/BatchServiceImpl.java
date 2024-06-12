package com.prista.pr_oil_selector.service.implementation;

import com.prista.pr_oil_selector.entity.*;
import com.prista.pr_oil_selector.service.IBatchService;
import com.prista.pr_oil_selector.utility.enums.RecommendationType;
import com.prista.pr_oil_selector.utility.exception.GlobalException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

@Service
public class BatchServiceImpl implements IBatchService {

    String brandId;
    String modelId;
    String vehicleId;
    String componentId;
    String componentCode;
    String productId;

    @Override
    public void createDatabaseAndContents(int sheetValue) throws GlobalException {
        String excelFilePath = "excel/Recomended Çalışma - ÖZKAN Tamamlandı 24.04.2024.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            createData(fileInputStream, workbook, sheetValue);
            workbook.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException("Sorun meydana geldi!");
        }
    }

    void createData(FileInputStream fileInputStream, Workbook workbook, int index) {
        Sheet sheet = workbook.getSheetAt(index);
        List<Map<String, Object>> dataList = new ArrayList<>();
        Row headerRow = sheet.getRow(0);
        List<String> headers = new ArrayList<>();

        List<String> brandList = new ArrayList<>();
        List<Brand> brandDbList = new ArrayList<>();
        List<String> modelList = new ArrayList<>();
        List<Model> modelDbList = new ArrayList<>();
        List<String> vehicleList = new ArrayList<>();
        List<Vehicle> vehicleDbList = new ArrayList<>();
        List<Component> componentDbList = new ArrayList<>();
        List<Product> productDbList = new ArrayList<>();

        for (Cell cell : headerRow) {
            headers.add(cell.getStringCellValue());
        }
        for (int i = 1; i <= 10; i++) {
            Row row = sheet.getRow(i);
            Map<String, Object> data = new HashMap<>();
            for (int j = 0; j < headers.size(); j++) {
                Cell cell = row.getCell(j);


                //j = 1 Make - Brand
                if (j == 1) {
                    String brandValue = getCellValue(cell);
                    if (brandValue != null && !brandList.contains(brandValue)) {
                        brandList.add(brandValue);
                        brandId = generateRandomId();
                        Brand brand = new Brand(null, brandValue, index + 1, brandId);
                        brandDbList.add(brand);
                    }
                }
                // j=2 Model
                else if (j == 2) {
                    String modelValue = getCellValue(cell);
                    if (modelValue != null && !modelList.contains(modelValue)) {
                        modelList.add(modelValue);
                        modelId = generateRandomId();
                        Model model = new Model(null, modelValue, brandId, modelId);
                        modelDbList.add(model);
                    }
                }
                // j=3 Vehicle - Type
                else if (j == 3) {
                    String vehicleValue = getCellValue(cell);
                    if (vehicleValue != null && !vehicleList.contains(vehicleValue)) {
                        vehicleList.add(vehicleValue);
                        vehicleId = generateRandomId();
                        int yearFrom = Integer.parseInt(getCellValue(row.getCell(4))); // J=4 YEAR FROM
                        int yearTo = Integer.parseInt(getCellValue(row.getCell(5))); // J=5 YEAR TO
                        Vehicle vehicle = new Vehicle(null, vehicleValue, yearFrom, yearTo, modelId, vehicleId);
                        vehicleDbList.add(vehicle);

                    }
                }

                // J=6 Component 1
                else if (j == 6) {
                    String componentValue = getCellValue(cell);
                    if (componentValue != null) {
                        componentId = generateRandomId();
                        componentCode = generateRandomComponentCode();
                        String componentVolumes = getCellValue(row.getCell(8)); // j= 8 Component 1 Volumes
                        Component component = new Component(null, componentValue, componentCode, componentVolumes, vehicleId, componentId);
                        componentDbList.add(component);
                    }
                }

                // J=9 Product 1 Recommended
                else if (j == 9) {
                    String productValue = getCellValue(cell);
                    if(productValue != null) {
                        productId = generateRandomId();
                        String serviceInternals = getCellValue(row.getCell(12)); // j= 12 serviceInternal 1
                        Product product = new Product(null, productValue, serviceInternals, RecommendationType.RECOMMEND.name(), productId, componentId, vehicleId);
                        productDbList.add(product);
                    }
                }
                // J=11 Alternate 1 Recommended
                else if (j == 11) {
                    String productValue = getCellValue(cell);
                    if(productValue != null) {
                        productId = generateRandomId();
                        String serviceInternals = getCellValue(row.getCell(12)); // j= 12 serviceInternal 1
                        Product product = new Product(null, productValue, serviceInternals, RecommendationType.ALTERNATE.name(), productId, componentId, vehicleId);
                        productDbList.add(product);
                    }
                }

            }
            dataList.add(data);
        }
    }

    private String getCellValue(Cell cell) {
        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:
                    return cell.getStringCellValue().toString();
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return cell.getDateCellValue().toString();
                    } else {
                        return String.valueOf(cell.getNumericCellValue());
                    }
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case FORMULA:
                    return String.valueOf(cell.getCellFormula());
                case BLANK:
                    return "";
                default:
                    return null;
            }
        } else {
            return null;
        }
    }

    private String generateRandomId() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString().replace("-", "");
        return uuidString.substring(0, 16);
    }

    private String generateRandomComponentCode() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString().replace("-", "");
        return uuidString.substring(0, 8);
    }

}
