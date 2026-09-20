// TaskRepository.java
// Cristian Manzo
// September 18, 2026
// Data access layer for the task table

package edu.fscj.cen3024c.taskmanager.repositories;

import edu.fscj.cen3024c.taskmanager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

// Extending JpaRepository hands us findAll, findById, save, and deleteById with no code written
// Task is the entity being stored, Integer is the type of its @Id field
public interface TaskRepository extends JpaRepository<Task, Integer> {
}