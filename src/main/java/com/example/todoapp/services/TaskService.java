package com.example.todoapp.services;

import com.example.todoapp.repositories.Repository;
import com.example.todoapp.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private Repository repository;

    public TaskService(Repository repository) {
        this.repository = repository;
    }

    public List<Task> getTasksList() {
        return repository.findAll();
    }

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public void deleteTask(String title) {
        repository.deleteByTitle(title);
    }

    public void updateTask(Task task) {
        System.out.println(task);

        repository.findByTitle(task.getTitle())
                .ifPresent(t -> {
                    t.setDescription(task.getDescription());
                    t.setDate(task.getDate());
                    t.isStatus(); //sprawdzić czy działa -dodać własnego gettera gdyby nie działało
                    repository.save(t);
                });
    }

    public Task getTaskByTitle(String title) {
        return repository.findByTitle(title).get();
    }

}
