package com.david.sanchez.apirest.service.dto;



import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskinDTO {

    private String title;
    private String description;
    private LocalDateTime eta;

}
