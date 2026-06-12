package com.example.todobackend.controller;

import com.example.todobackend.entity.Todo;
import com.example.todobackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173")
public class TodoController {

    @Autowired
    private TodoService todoService;
    @PostMapping("/tasks")
    public Todo createTask(@RequestBody Todo todo){
        return todoService.save(todo);
    }
    @GetMapping("/all")
    private List<Todo> allTodo(){
        return todoService.getAll();
    }
    @PutMapping("/tasks/{id}")
    private Todo updateTask(@PathVariable Long id, @RequestBody Todo todo){
        return todoService.updateTask(id,todo);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        todoService.deleteTask(id);
        return "Task Deleted";
    }
}
