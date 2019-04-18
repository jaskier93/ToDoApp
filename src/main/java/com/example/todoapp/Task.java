package com.example.todoapp;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Data //gettery, settery, toString, hashCode, equals
@Table(name = "ToDo")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false) //unikalne+nie może być nullem
    private String title;

    @Column
    private String description;

    @Column(name = "date")
    private Date dateOfTask;

    @Column
    private boolean isDone;
    //ustawiać automatycznie jako false (niewykonano) przy dodawaniu nowego zadania przez usera
}
