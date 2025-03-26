package org.howard.edu.lsp.assignment5;

/**
 * Driver class to test the IntegerSet class.
 */
public class Driver {
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Value of Set1: " + set1.toString());
        System.out.println("Smallest value in Set1: " + set1.smallest());
        System.out.println("Largest value in Set1: " + set1.largest());

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("Value of Set2: " + set2.toString());

        System.out.println("Union of Set1 and Set2");
        set1.union(set2);
        System.out.println("Result of union: " + set1.toString());

        System.out.println("Intersection of Set1 and Set2");
        set1.intersect(set2);
        System.out.println("Result of intersection: " + set1.toString());

        System.out.println("Difference of Set1 and Set2");
        set1.diff(set2);
        System.out.println("Result of difference: " + set1.toString());

        System.out.println("Checking if Set1 contains 2: " + set1.contains(2));
        System.out.println("Checking if Set2 contains 4: " + set2.contains(4));

        set1.clear();
        System.out.println("Cleared Set1. Is empty? " + set1.isEmpty());
    }
}
