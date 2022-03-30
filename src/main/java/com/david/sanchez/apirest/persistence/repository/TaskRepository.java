package com.david.sanchez.apirest.persistence.repository;

import com.david.sanchez.apirest.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
