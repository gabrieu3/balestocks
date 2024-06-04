package com.balestocks.scrap.service;

import com.balestocks.scrap.domain.dto.StockInvestSiteDto;
import com.opencsv.CSVWriter;
import lombok.Builder;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CsvGeneratorService {

    public static void generateCsv(List<StockInvestSiteDto> stockList) throws IOException, IllegalAccessException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(generateFileName()))) {
            // Create header
            List<String> header = new ArrayList<>();
            header.add("stockCode");

            // Adding fields from StockInvestSiteDto and its inner classes
            addFieldsToHeader(header, StockInvestSiteDto.class, new HashSet<>());

            writer.writeNext(header.toArray(new String[0]));

            // Write data
            for (StockInvestSiteDto stock : stockList) {
                List<String> line = new ArrayList<>();
                line.add(stock.getStockCode() != null ? stock.getStockCode().toString() : "");

                // Adding values from StockInvestSiteDto and its inner classes
                addValuesToLine(line, stock, new HashSet<>());

                writer.writeNext(line.toArray(new String[0]));
            }
        }
    }

    private static void addFieldsToHeader(List<String> header, Class<?> clazz, Set<Class<?>> processedClasses) {
        if (processedClasses.contains(clazz)) {
            return;
        }
        processedClasses.add(clazz);

        for (Field field : clazz.getDeclaredFields()) {
            if (isComplexType(field)) {
                addFieldsToHeader(header, field.getType(), processedClasses);
            } else {
                header.add(field.getName());
            }
        }
    }

    private static void addValuesToLine(List<String> line, Object obj, Set<Class<?>> processedClasses) throws IllegalAccessException {
        if (obj == null || processedClasses.contains(obj.getClass())) {
            return;
        }
        processedClasses.add(obj.getClass());

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);
            if (isComplexType(field)) {
                addValuesToLine(line, value, processedClasses);
            } else {
                line.add(value != null ? value.toString() : "");
            }
        }
    }

    private static boolean isComplexType(Field field) {
        return !field.getType().isPrimitive() && !field.getType().getName().startsWith("java.lang") && !field.getType().isEnum();
    }

    private static String generateFileName() {
        // Obtém a data e hora atual
        LocalDateTime now = LocalDateTime.now();

        // Define o formato desejado para a data e hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");

        // Formata a data e hora
        String formattedDateTime = now.format(formatter);

        // Concatena "InvesteSiteData" com a data e hora formatada e ".csv"
        String fileName = "InvesteSiteData_" + formattedDateTime + ".csv";

        return fileName;
    }

}