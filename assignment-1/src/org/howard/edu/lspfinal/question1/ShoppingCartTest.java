package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }
    // 1. ADDING ITEMS
    @Test
    @DisplayName("Test for adding valid item")
    public void testAddValidItem() {
        cart.addItem("Notebook", 5.99);
        assertEquals(5.99, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    public void testAddItemWithZeroPrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Free Sticker", 0.0);
        });
        assertEquals("Price must be greater than 0.", exception.getMessage());
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    public void testAddItemWithNegativePrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("ScamItem", -5.0);
        });
        assertEquals("Price must be greater than 0.", exception.getMessage());
    }


    // 2. APPLYING DISCOUNT CODES

    @Test
    @DisplayName("Test applying discount code SAVE10")
    public void testApplySave10() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying discount code SAVE20")
    public void testApplySave20() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying invalid discount code (expect exception)")
    public void testApplyInvalidDiscountCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
        assertEquals("Invalid discount code.", exception.getMessage());
    }
    // 3. TOTAL COST TESTS

    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        cart.addItem("Textbook", 50.0);
        cart.addItem("Binder", 10.0);
        assertEquals(60.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        cart.addItem("Shoes", 100.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(90.0, cart.getTotalCost());
    }
    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalCostEmptyCart() {
        assertEquals(0.0, cart.getTotalCost());
    }
    // 4. REMOVE ITEM 
    @Test
    @DisplayName("Test for adding item with empty name (should still add)")
    public void testAddItemWithEmptyName() {
        cart.addItem("", 7.0);
        assertEquals(7.0, cart.getTotalCost());
    }
}
