package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ETLPipeline {
	
    public static void main(String[] args) {
        String inputFilePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";
        
        List<String[]> products = extract(inputFilePath);
        if (products != null) {
            List<String[]> transformedProducts = transform(products);
            load(transformedProducts, outputFilePath);
        }
    }

    private static List<String[]> extract(String filePath) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

 
                if (values.length < 4) {
                    System.out.println("Skipping malformed line: " + Arrays.toString(values));
                    continue;
                }

                records.add(values);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
            e.printStackTrace();
            return null;
        }
        return records;
    }


    private static List<String[]> transform(List<String[]> products) {
        List<String[]> transformed = new ArrayList<>();
        transformed.add(new String[]{"ProductID", "Name", "Price", "Category", "PriceRange"});
        
        for (String[] product : products) {
            String id = product[0];
            String name = product[1].toUpperCase(); // Convert name to uppercase
            double price = Double.parseDouble(product[2]);
            String category = product[3];

            // Apply discount if Electronics
            if (category.equals("Electronics")) {
                price *= 0.9;
                price = Math.round(price * 100.0) / 100.0; // Round to two decimal places
            }
            
            // Change category if price > 500
            if (category.equals("Electronics") && price > 500) {
                category = "Premium Electronics";
            }
            
            // Assign price range
            String priceRange = "";
            if (price <= 10) {
                priceRange = "Low";
            } else if (price <= 100) {
                priceRange = "Medium";
            } else if (price <= 500) {
                priceRange = "High";
            } else {
                priceRange = "Premium";
            }
            
            transformed.add(new String[]{id, name, String.format("%.2f", price), category, priceRange});
        }
        return transformed;
    }

    private static void load(List<String[]> transformedProducts, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] product : transformedProducts) {
                writer.write(String.join(",", product));
                writer.newLine();
            }
            System.out.println("Transformation complete. Output written to " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filePath);
        }
    }
}
