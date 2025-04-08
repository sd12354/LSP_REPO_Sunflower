package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class IntegerSetTest {

    @Test
    @DisplayName("Test clear method")
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Test length of set")
    public void testLength() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length());
        set.add(10);
        set.add(20);
        assertEquals(2, set.length());
    }

    @Test
    @DisplayName("Test if two sets are equal")
    public void testEquals() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(5);
        set1.add(10);
        set2.add(10);
        set2.add(5);
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("Test contains method")
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        assertTrue(set.contains(3));
        assertFalse(set.contains(7));
    }

    @Test
    @DisplayName("Test getting largest value")
    public void testLargest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(8);
        set.add(1);
        assertEquals(8, set.largest());
    }

    @Test
    @DisplayName("Test largest throws exception on empty set")
    public void testLargestException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> {
            set.largest();
        });
    }

    @Test
    @DisplayName("Test getting smallest value")
    public void testSmallest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(9);
        set.add(2);
        set.add(6);
        assertEquals(2, set.smallest());
    }

    @Test
    @DisplayName("Test smallest throws exception on empty set")
    public void testSmallestException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> {
            set.smallest();
        });
    }

    @Test
    @DisplayName("Test add method (no duplicates)")
    public void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(4); // should not add duplicate
        assertEquals(1, set.length());
        assertTrue(set.contains(4));
    }

    @Test
    @DisplayName("Test remove method")
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(6);
        set.add(7);
        set.remove(6);
        assertFalse(set.contains(6));
        set.remove(100); // trying to remove something not in the set
    }

    @Test
    @DisplayName("Test union of two sets")
    public void testUnion() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set2.add(2);
        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
    }

    @Test
    @DisplayName("Test intersection of two sets")
    public void testIntersect() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(5);
        set1.add(10);
        set2.add(10);
        set2.add(15);
        set1.intersect(set2);
        assertEquals(1, set1.length());
        assertTrue(set1.contains(10));
    }

    @Test
    @DisplayName("Test difference between two sets")
    public void testDiff() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(3);
        set1.add(4);
        set2.add(4);
        set1.diff(set2);
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(4));
    }

    @Test
    @DisplayName("Test complement method")
    public void testComplement() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);

        set1.complement(set2);  // Remove any shared elements
        
        assertTrue(set1.contains(1));  // 1 is not in set2, should stay
        assertFalse(set1.contains(2)); // 2 is in both, should be removed
        assertFalse(set1.contains(3)); // 3 wasn't in set1 anyway
    }

    @Test
    @DisplayName("Test isEmpty method")
    public void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
        set.add(7);
        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Test toString method")
    public void testToString() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        String output = set.toString();
        assertTrue(output.contains("1"));
        assertTrue(output.contains("2"));
    }
}