package org.group39fsworkingproject.dto.taskDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskCreateRequestDto {

    private String taskName;
    private String taskDescription;
    private LocalDateTime deadline;
    private String managerEmail;

}
