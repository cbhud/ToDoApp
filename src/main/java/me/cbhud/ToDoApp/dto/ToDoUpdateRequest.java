package me.cbhud.ToDoApp.dto;

public record ToDoUpdateRequest(
        String title,
        Boolean completed
) {
}