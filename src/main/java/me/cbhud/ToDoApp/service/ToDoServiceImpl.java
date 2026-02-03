package me.cbhud.ToDoApp.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import me.cbhud.ToDoApp.dto.ToDoCreateRequest;
import me.cbhud.ToDoApp.dto.ToDoResponse;
import me.cbhud.ToDoApp.dto.ToDoUpdateRequest;
import me.cbhud.ToDoApp.model.ToDo;
import me.cbhud.ToDoApp.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository repository;

    public ToDoServiceImpl(ToDoRepository repository){
        this.repository = repository;
    }

    @Override
    public ToDoResponse create(ToDoCreateRequest request){
        ToDo toDo = ToDo.builder()
                .title(request.title().trim())
                .completed(false)
                .build();

        ToDo saved = repository.save(toDo);
        return mapToResponse(saved);
    }

    @Override
    public List<ToDoResponse> findAll() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ToDoResponse findById(Long id) {
        ToDo toDo = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ToDo not found with id: " + id));
        return mapToResponse(toDo);
    }

    @Override
    public ToDoResponse update(Long id, ToDoUpdateRequest request) {
        ToDo toDo = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ToDo not found with id: " + id));

        if (request.title() != null && !request.title().isBlank()) {
            toDo.setTitle(request.title().trim());
        }
        if (request.completed() != null) {
            toDo.setCompleted(request.completed());
        }

        ToDo updated = repository.save(toDo);
        return mapToResponse(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("ToDo not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private ToDoResponse mapToResponse(ToDo toDo) {
        return new ToDoResponse(
                toDo.getId(),
                toDo.getTitle(),
                toDo.isCompleted(),
                toDo.getCreatedAt()
        );
    }
}