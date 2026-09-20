// TaskController.java
// Cristian Manzo
// September 20, 2026
// REST endpoints for the task API

package edu.fscj.cen3024c.taskmanager.controllers;

import edu.fscj.cen3024c.taskmanager.entities.Task;
import edu.fscj.cen3024c.taskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Every URL in this class starts with /tasks
@RestController
@RequestMapping("/tasks")
public class TaskController {

    // Spring hands us the service, we never build it ourselves
    @Autowired
    private TaskService taskService;

    // GET /tasks returns every task
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.findAll();
    }

    // GET /tasks/1 returns a single task, or a 404 when that id is missing
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Integer id) {
        return taskService.findById(id);
    }

    // POST /tasks turns the JSON body into a Task and stores it
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        System.out.println(task);
        return taskService.save(task);
    }

    // PUT /tasks/1 loads the existing row, overwrites its fields, and saves it back
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Integer id, @RequestBody Task task) {
        Task existingTask = taskService.findById(id);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setDueDate(task.getDueDate());
        return taskService.save(existingTask);
    }

    // DELETE /tasks/1 removes the row and answers 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}