package com.example.todo.controller;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {
    private List<Todo> todoList = new ArrayList<>();
    private int idCounter = 1;

    @GetMapping
    public String viewTodos(Model model) {
        model.addAttribute("todos", todoList);
        return "todoList";
    }

    @PostMapping("/create")
    public String createTodo(@RequestParam String title) {
        Todo newTodo = new Todo(idCounter++, title);
        todoList.add(newTodo);
        return "redirect:/todos";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        todoList.removeIf(todo -> todo.getId() == id);
        return "redirect:/todos";
    }
}
