package com.david.sanchez.apirest.mapper;

import com.david.sanchez.apirest.persistence.entity.Task;
import com.david.sanchez.apirest.persistence.entity.TaskStatus;
import com.david.sanchez.apirest.service.dto.TaskinDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskinDTOToTask implements IMapper<TaskinDTO, Task>{

    @Override
    public Task map(TaskinDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
