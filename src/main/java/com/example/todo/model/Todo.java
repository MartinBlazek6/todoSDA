package com.example.todo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Date dueDate;
    private Boolean isDone;

    public Todo(String title, Date dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.isDone = false;
    }
}
