package com.hieudoanm.javabackendstarter.controller;

import com.hieudoanm.javabackendstarter.dto.task.TaskDto;
import com.hieudoanm.javabackendstarter.dto.task.TaskRequestDto;
import com.hieudoanm.javabackendstarter.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tasks", produces = APPLICATION_JSON_VALUE)
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public TaskDto createTask(@Validated @RequestBody TaskRequestDto taskRequest) {
        return taskService.createTask(taskRequest);
    }

    @GetMapping("/{id}")
    public TaskDto getTask(
            @PathVariable(value = "id") String id
    ) {
        return taskService.getTask(id);
    }

    @PutMapping("/{id}")
    public TaskDto updateTask(
            @PathVariable(value = "id") String id,
            @Validated @RequestBody TaskRequestDto taskRequest
    ) throws Exception {
        return taskService.updateTask(id, taskRequest);
    }

    @PatchMapping("/{id}")
    public TaskDto patchTask(
            @PathVariable(value = "id") String id,
            @Validated @RequestBody TaskRequestDto taskRequest
    ) throws Exception {
        return taskService.updateTask(id, taskRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(
            @PathVariable(value = "id") String id
    ) {
        taskService.deleteTask(id);
    }
}
