package com.taskinator.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private Date created;
    private Date updated;
    private Date start;
    private Date end;
    private UserDTO userDTO;
    private PriorityTaskDTO priorityTaskDTO;
}
