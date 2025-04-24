package org.howard.edu.lspfinal.question3;

/**
 * Represents an inventory report
 * Overrides steps to customize the behavior for inventory
 */
public class InventoryReport extends ReportGenerator {

    @Override
    protected void loadData() {
        System.out.println("Loading inventory data...");
    }

    @Override
    protected void formatData() {
        System.out.println("Formatting inventory data...");
    }

    @Override
    protected void printReport() {
        System.out.println("Printing inventory report.\n");
    }
}
