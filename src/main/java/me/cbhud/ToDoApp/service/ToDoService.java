package me.cbhud.ToDoApp.service;

import me.cbhud.ToDoApp.dto.ToDoCreateRequest;
import me.cbhud.ToDoApp.dto.ToDoResponse;
import me.cbhud.ToDoApp.dto.ToDoUpdateRequest;
import java.util.List;

public interface ToDoService {
    ToDoResponse create(ToDoCreateRequest request);
    List<ToDoResponse> findAll();
    ToDoResponse findById(Long id);
    ToDoResponse update(Long id, ToDoUpdateRequest request);
    void delete(Long id);
}