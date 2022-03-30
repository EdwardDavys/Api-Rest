package com.david.sanchez.apirest.controller;

import com.david.sanchez.apirest.persistence.entity.Task;
import com.david.sanchez.apirest.service.TaskService;
import com.david.sanchez.apirest.service.dto.TaskinDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private    final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public Task createTask(@RequestBody TaskinDTO taskinDTO){
       return this.taskService.createTask(taskinDTO);
    }
}
