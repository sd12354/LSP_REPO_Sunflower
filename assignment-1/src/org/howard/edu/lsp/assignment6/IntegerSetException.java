package org.howard.edu.lsp.assignment6;

/**
 * Custom exception class for IntegerSet operations.
 * Thrown when operations like largest() or smallest()
 * are called on an empty set.
 */
public class IntegerSetException extends Exception {
    public IntegerSetException(String message) {
        super(message);
    }
}
