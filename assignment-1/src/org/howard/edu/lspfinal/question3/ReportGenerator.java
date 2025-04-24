package org.howard.edu.lspfinal.question3;

/**
 * Defines the template method for generating reports
 */
public abstract class ReportGenerator {
    /**
     * Template method that outlines the steps of generating a report
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Load the data for the report
     */
    protected abstract void loadData();

    /**
     * Format the data for the report
     */
    protected abstract void formatData();

    /**
     * Print the final report
     */
    protected abstract void printReport();
}
