package com.example.todoapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository<Task, Integer> {

    void deleteByTitle(String title);

    Optional<Task> findByTitle(String title);
}
