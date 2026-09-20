// Task.java
// Cristian Manzo
// September 20, 2026
// Entity class that maps the task table into Java

package edu.fscj.cen3024c.taskmanager.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

// @Entity marks this class as a database table, @Table names which one
@Entity
@Table(name = "task")
public class Task {

    // Primary key, assigned by PostgreSQL rather than by our code
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    // Required field, matches the not null title column
    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    // Optional field, the column allows nulls
    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    // Required field holding PENDING, IN_PROGRESS, or COMPLETED
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    // The column is named due_date, the Java field is dueDate, so @Column bridges the two
    @Column(name = "due_date")
    private LocalDate dueDate;

    // Getters and setters, used by both JPA and the JSON converter to read and write this object

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

}