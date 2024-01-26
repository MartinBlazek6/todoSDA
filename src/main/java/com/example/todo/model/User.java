package com.example.todo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "`user`")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
}
