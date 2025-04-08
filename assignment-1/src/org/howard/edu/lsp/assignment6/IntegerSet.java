package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a set of integers with basic set operations.
 */
public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();
    /**
     * Default constructor initializes an empty set.
     */
    public IntegerSet() {
    }
    /**
     * Constructor that initializes the set with the given elements.
     * @param set An ArrayList of integers
     */
    public IntegerSet(ArrayList<Integer> set) {
        for (int num : set) {
            add(num);
        }
    }

    /**
     * Clears the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set.
     * @return The number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if the set contains a specific value.
     * @param value The integer to check
     * @return True if the value is in the set otherwise false.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     * @return The maximum value in the set.
     */
    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        int max = set.get(0);
        for (int i = 1; i < set.size(); i++) {
            if (set.get(i) > max) {
                max = set.get(i);
            }
        }
        return max;
    }

    /**
     * Returns the smallest value in the set.
     * @return The minimum value in the set.
     */
    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        int min = set.get(0);
        for (int i = 1; i < set.size(); i++) {
            if (set.get(i) < min) {
                min = set.get(i);
            }
        }
        return min;
    }
    /**
     * Adds an element to the set if it's not already present.
     * @param item The integer to add.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an element from the set if present.
     * @param item The integer to remove
     */
    public void remove(int item) {
        set.remove((Integer) item);
    }

    /**
     * Computes the union of this set with another set.
     * @param intSetb Another IntegerSet
     */
    public void union(IntegerSet intSetb) {
        for (int num : intSetb.set) {
            add(num);
        }
    }

    /**
     * Computes the intersection of this set with another set.
     * @param intSetb Another IntegerSet
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Computes the difference between this set and another set.
     * @param intSetb Another IntegerSet
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Computes the complement of this set with another set.
     * @param intSetb Another IntegerSet
     */
    public void complement(IntegerSet intSetb) {
        for (Integer item : intSetb.set) {
            if (this.set.contains(item)) {
                this.set.remove(item);
            }
        }
    }

    /**
     * Checks if the set is empty.
     * @return True if the set is empty, otherwise false
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Checks if two sets are equal.
     * @param o Another object
     * @return True if the sets contain the same elements, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet otherSet = (IntegerSet) o;
        return set.containsAll(otherSet.set) && otherSet.set.containsAll(set);
    }

    /**
     * Returns a string representation of the set.
     * @return A string containing set elements
     */
    @Override
    public String toString() {
        return set.toString();
    }
}
