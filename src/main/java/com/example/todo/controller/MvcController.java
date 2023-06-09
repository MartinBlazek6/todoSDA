package com.example.todo.controller;


import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class MvcController {
    private final TodoService todoService;


    @GetMapping("/")
    public String getAllTodos(Model model){
        model.addAttribute("todos",todoService.getAllTodos());
        return "index";
    }

    @PostMapping("/changeStatus")
    public String changeStatus(@RequestParam Long id){
        todoService.changeStatus(id);
        return "redirect:/";
    }

    @PostMapping("/createTodo")
    public String createTodo(@RequestParam String title, String date){
        todoService.createTodo(title,todoService.convertStringToDate(date));
        return "redirect:/";
    }

    @PostMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable Long id){
        todoService.deletedTodo(id);
        return "redirect:/";
    }


}
