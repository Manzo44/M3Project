// TaskService.java
// Cristian Manzo
// September 20, 2026
// Service layer that reads and writes tasks through the database

package edu.fscj.cen3024c.taskmanager.services;

import edu.fscj.cen3024c.taskmanager.entities.Task;
import edu.fscj.cen3024c.taskmanager.exceptions.TaskNotFoundException;
import edu.fscj.cen3024c.taskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    // Spring builds the repository at startup and hands it to us here
    @Autowired
    private TaskRepository taskRepository;

    // Returning every row in the task table
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    // Looking up one task, throwing a 404 exception when the id is not in the table
    public Task findById(Integer id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    // Saving a new task or updating an existing one, the database assigns the id
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    // Removing a task by id
    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }
}