package com.yolo.model;

import com.yolo.utils.TaskCategories;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "timetable", schema = "dzienniczekdbapp")
public class TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "subject")
    private String subject;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "task_date", nullable = false)
    private LocalDate taskDate;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
