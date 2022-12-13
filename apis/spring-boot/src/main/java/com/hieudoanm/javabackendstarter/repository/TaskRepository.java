package com.hieudoanm.javabackendstarter.repository;

import com.hieudoanm.javabackendstarter.dto.task.TaskDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<TaskDto, String> {
    List<TaskDto> findAll();
}
