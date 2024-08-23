package org.group39fsworkingproject.dto.taskDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group39fsworkingproject.dto.managerDto.ManagerResponseDto;
import org.group39fsworkingproject.entity.Manager;
import org.group39fsworkingproject.entity.TaskStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateResponseDto {

    private Integer id;
    private String taskName;
    private String taskDescription;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private LocalDateTime deadline;
    private TaskStatus status;
    /*
    private String managerName
    или проставить более развернутую информацию
    о менеджере - но не полную - используя Dto
     */
    private ManagerResponseDto managerResponseDto;

}
