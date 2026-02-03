package me.cbhud.ToDoApp.dto;

import java.time.Instant;

public record ToDoResponse(
        Long id,
        String title,
        boolean completed,
        Instant createdAt
) {
}