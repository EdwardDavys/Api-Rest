package com.david.sanchez.apirest.service;

import com.david.sanchez.apirest.mapper.TaskinDTOToTask;
import com.david.sanchez.apirest.persistence.entity.Task;
import com.david.sanchez.apirest.persistence.repository.TaskRepository;
import com.david.sanchez.apirest.service.dto.TaskinDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskinDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskinDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskinDTO taskinDTO){
        Task task = mapper.map(taskinDTO);
        return this.repository.save(task);
    }
}
