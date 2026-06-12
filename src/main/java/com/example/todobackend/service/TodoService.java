package com.example.todobackend.service;

import com.example.todobackend.entity.Todo;
import com.example.todobackend.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    public Todo save(Todo todo) {
        return todoRepo.save(todo);
    }


    public List<Todo> getAll() {
        return todoRepo.findAll();
    }

    public Todo updateTask(Long id,Todo updatedTodo) {
        Todo todo=todoRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Task not found"));
        todo.setTasks(updatedTodo.getTasks());
        return todoRepo.save(todo);
    }

    public void deleteTask(Long id) {
        todoRepo.deleteById(id);
    }
}
