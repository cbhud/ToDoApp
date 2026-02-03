package me.cbhud.ToDoApp.controller;

import me.cbhud.ToDoApp.dto.ToDoCreateRequest;
import me.cbhud.ToDoApp.dto.ToDoResponse;
import me.cbhud.ToDoApp.dto.ToDoUpdateRequest;
import me.cbhud.ToDoApp.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoResponse create(@RequestBody ToDoCreateRequest request){
        return toDoService.create(request);
    }

    @GetMapping
    public List<ToDoResponse> getAll() {
        return toDoService.findAll();
    }

    @GetMapping("/{id}")
    public ToDoResponse getById(@PathVariable Long id) {
        return toDoService.findById(id);
    }

    @PutMapping("/{id}")
    public ToDoResponse update(@PathVariable Long id, @RequestBody ToDoUpdateRequest request) {
        return toDoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        toDoService.delete(id);
    }
}