package com.example.todo.controller;


import com.example.todo.model.DTO.TodoDto;
import com.example.todo.model.Todo;
import com.example.todo.service.DateService;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1")
@Slf4j
public class RestController {

    private final TodoService todoService;
    private final DateService dateService;

    @PostMapping("/create")
    public ResponseEntity<String> createTodo(@RequestBody TodoDto todoDto) {
        return dateService.validateAndCreateTodo(todoDto);
    }

    @GetMapping("/allTodos")
    public ResponseEntity<List<Todo>> getAllTodos() {
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }
    @GetMapping("/getByStatus")
    public ResponseEntity<List<Todo>> getAllByStatus(@RequestParam Boolean status){
        return new ResponseEntity<>(todoService.getAllByStatus(status),HttpStatus.OK);
    }

    @PatchMapping("/change")
    public ResponseEntity<String> update(@RequestParam String id) {
        todoService.changeStatus(Long.valueOf(id));
        return new ResponseEntity<>("status changed", HttpStatus.OK);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam String id) {
        todoService.deletedTodo(Long.valueOf(id));
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }


}
