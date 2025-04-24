package org.howard.edu.lspfinal.question3;

/**
 * Driver class for demonstrating the report generation system
 * using the Template Method design pattern
 */
public class Driver {
    public static void main(String[] args) {
        ReportGenerator sales = new SalesReport();
        ReportGenerator inventory = new InventoryReport();

        sales.generateReport();
        inventory.generateReport();
    }
}
