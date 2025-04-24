package org.howard.edu.lspfinal.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple shopping cart that allows adding and removing items,
 * applying discount codes, and calculating the total cost.
 */
public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    /**
     * Adds an item to the shopping cart.
     * 
     * @param itemName  the name of the item
     * @param price     the price of the item (must be greater than 0)
     * @throws IllegalArgumentException if price is negative
     */
    /**
     * Removes an item from the shopping cart.
     * 
     * @param itemName the name of the item to remove
     */
    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    public void addItem(String itemName, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
        items.put(itemName, price);
    }

    /**
     * Returns the number of items in the cart.
     * 
     * @return number of items
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Calculates and returns the total cost of the cart,
     * applying any discount currently applied.
     * 
     * @return total cost after applying discount
     */
    public double getTotalCost() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        double discountAmount = total * (discountPercentage / 100.0);
        return total - discountAmount;
    }

    /**
     * Applies a valid discount code to the shopping cart.
     * Supported codes:
     * - "SAVE10": 10% discount
     * - "SAVE20": 20% discount
     * 
     * @param code  the discount code
     * @throws IllegalArgumentException if the code is invalid
     */
    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    /**
     * Returns the discount percentage currently applied.
     * 
     * @return discount percentage
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
