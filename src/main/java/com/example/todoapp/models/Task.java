package com.example.todoapp.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data //gettery, settery, toString, hashCode, equals
@Table(name = "todo")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title" ,unique = true, nullable = false) //unikalne+nie może być nullem
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    //ustawiać automatycznie jako false (niewykonano) przy dodawaniu nowego zadania
    @Column(name = "status")
    private boolean status;

    public String status() {
        return status? "Done": "To do!";
    }


}
