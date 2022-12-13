package com.hieudoanm.javabackendstarter.service;

import com.hieudoanm.javabackendstarter.dto.task.TaskDto;
import com.hieudoanm.javabackendstarter.dto.task.TaskRequestDto;
import com.hieudoanm.javabackendstarter.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDto> getTasks() {
        return taskRepository.findAll();
    }

    public TaskDto createTask(TaskRequestDto taskRequest) {
        TaskDto taskDto = new TaskDto();
        String uuid = UUID.randomUUID().toString();
        taskDto.setId(uuid);
        taskDto.setTitle(taskRequest.getTitle());
        taskDto.setDescription(taskRequest.getDescription());
        taskDto.setListId(taskRequest.getListId());
        taskDto.setCompleted(taskRequest.getCompleted());
        return taskRepository.save(taskDto);
    }

    public TaskDto getTask(String id) {
        return taskRepository.findById(id).orElse(null);
    }

    public TaskDto updateTask(String id, TaskRequestDto taskRequest) throws Exception {
        TaskDto taskDto = taskRepository.findById(id).orElse(null);
        if (taskDto == null) {
            throw new Exception("Error Message");
        }
        taskDto.setTitle(taskRequest.getTitle());
        taskDto.setDescription(taskRequest.getDescription());
        taskDto.setListId(taskRequest.getListId());
        taskDto.setCompleted(taskRequest.getCompleted());
        taskRepository.save(taskDto);
        return taskDto;
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
