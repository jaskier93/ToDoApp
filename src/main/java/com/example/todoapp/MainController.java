package com.example.todoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin
public class MainController {
    private TaskService taskService;

    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.getTasksList());
        return "index";
    }

    @GetMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        System.out.println(task.getDateOfTask());
        taskService.addTask(task);
        return "redirect:/";
    }


    @GetMapping("/update")
    public String updateTask(@ModelAttribute Task task) {
        System.out.println(task.getDateOfTask());
        taskService.updateTask(task);
        return "redirect:/";

    }

    @GetMapping("/delete")
    public String deleteTask(@RequestParam(value = "task") String title) {
        taskService.deleteTask(title);
        return "redirect:/";
    }


    @GetMapping("/updateinfo")
    public String updateInfo(@RequestParam(value = "task") String title, Model model) {
        Task task = taskService.getTaskByTitle(title);
        model.addAttribute("task", task);
        return "update";
    }

}
