package com.example.todoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class MainController {
    private TaskService taskService;

    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("task", taskService.getTasksList());
        return "index";
    }

    @GetMapping("/add")
    public String addTask(@ModelAttribute Task task) {
 //       System.out.println(task.getDate());
        taskService.addTask(task);
        return "redirect:/";
    }


    @GetMapping("/update")
    public String updateTask(@ModelAttribute Task task) {
   //     System.out.println(task.getDate());
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
