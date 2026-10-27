package com.github.PetersonSantos9K.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService todoService){
        this.service = todoService;
    }

    @PostMapping
    public TodoEntity salver(@RequestBody TodoEntity todo){
        try{
            return this.service.salver(todo);
        } catch (IllegalArgumentException err){
            var mensagemErro = err.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
        }

    }

    @PutMapping("{id}")
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo){
        todo.setId(id);
        service.atualizarStatus(todo);
    }

    @GetMapping("{id}")
    public TodoEntity buscar(@PathVariable("id") Integer id){
        return this.service.buscarPorId(id);
    }

}

