package me.cbhud.ToDoApp.repository;

import me.cbhud.ToDoApp.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    ToDo findByTitle(String title);

}
