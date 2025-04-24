package org.howard.edu.lspfinal.question2;

/**
 * Represents a task with a name, priority, and status
 */
public class Task {
    private String name;
    private int priority;
    private String status;

    /**
     * Constructs a new Task object
     * @param name Task name
     * @param priority Priority level (lower is higher priority)
     * @param status Status of the task ("TODO", "IN_PROGRESS", "DONE")
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the task.
     */
    @Override
    public String toString() {
        return "  Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}
