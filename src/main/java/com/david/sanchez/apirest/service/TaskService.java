package com.david.sanchez.apirest.service;

import com.david.sanchez.apirest.exceptions.ToDoExceptions;
import com.david.sanchez.apirest.mapper.TaskinDTOToTask;
import com.david.sanchez.apirest.persistence.entity.Task;
import com.david.sanchez.apirest.persistence.entity.TaskStatus;
import com.david.sanchez.apirest.persistence.repository.TaskRepository;
import com.david.sanchez.apirest.service.dto.TaskinDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskinDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskinDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskinDTO taskinDTO) {
        Task task = mapper.map(taskinDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll() {
        return this.repository.findAll();

    }

    public List<Task> findAllByTaskStatus(TaskStatus taskStatus) {
        return this.repository.findAllByTaskStatus(taskStatus);
    }

    @Transactional
    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

}
