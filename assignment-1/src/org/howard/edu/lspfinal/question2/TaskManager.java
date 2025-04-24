package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Manages tasks using a HashMap and supports task creation, retrieval, updates, and reporting.
 */
public class TaskManager {
    private Map<String, Task> taskMap = new HashMap<>();

    /**
     * Adds a new task to the manager.
     * @param name Task name (must be unique)
     * @param priority Task priority
     * @param status Task status
     * @throws DuplicateTaskException if the task already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (taskMap.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        Task newTask = new Task(name, priority, status);
        taskMap.put(name, newTask);
    }

    /**
     * Retrieves a task by its name.
     * @param name Task name
     * @return the corresponding Task object
     * @throws TaskNotFoundException if task doesn't exist
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!taskMap.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return taskMap.get(name);
    }

    /**
     * Updates the status of an existing task.
     * @param name Task name
     * @param newStatus New status value
     * @throws TaskNotFoundException if task doesn't exist
     */
    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(newStatus);
    }

    /**
     * Prints all tasks grouped by their current status.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        Map<String, List<Task>> grouped = new HashMap<>();

        for (Task task : taskMap.values()) {
            grouped.computeIfAbsent(task.getStatus(), k -> new ArrayList<>()).add(task);
        }

        for (String status : List.of("TODO", "IN_PROGRESS", "DONE")) {
            System.out.println(status + ":");
            List<Task> tasks = grouped.getOrDefault(status, new ArrayList<>());
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}
