package org.howard.edu.lspfinal.question2;

/**
 * Custom exception thrown when a task is not found in the TaskManager
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
