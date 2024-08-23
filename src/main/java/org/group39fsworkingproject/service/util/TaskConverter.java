package org.group39fsworkingproject.service.util;

import org.group39fsworkingproject.dto.managerDto.ManagerResponseDto;
import org.group39fsworkingproject.dto.taskDto.TaskCreateRequestDto;
import org.group39fsworkingproject.dto.taskDto.TaskCreateResponseDto;
import org.group39fsworkingproject.dto.taskDto.TaskResponseDto;
import org.group39fsworkingproject.entity.Role;
import org.group39fsworkingproject.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter {

    public Task fromCreateRequest(TaskCreateRequestDto dto){
        Task task = new Task();

        task.setTaskName(dto.getTaskName());
        task.setTaskDescription(dto.getTaskDescription());
        task.setDeadline(dto.getDeadline());

        return task;
    }


    public TaskCreateResponseDto toCreateDto(Task task){
        TaskCreateResponseDto dto = new TaskCreateResponseDto();
        dto.setId(task.getId());
        dto.setTaskName(task.getTaskName());
        dto.setTaskDescription(task.getTaskDescription());
        dto.setCreateDate(task.getCreateDate());
        dto.setLastUpdate(task.getLastUpdate());
        dto.setDeadline(task.getDeadline());
        dto.setStatus(task.getStatus());

        Role managerRole = task.getManager().getRole();

        dto.setManagerResponseDto(new ManagerResponseDto(
                task.getManager().getId(),
                task.getManager().getManagerName(),
                task.getManager().getEmail(),
                managerRole.getName()
        ));

        return dto;

    }

    public TaskResponseDto toDto(Task task){
        TaskResponseDto dto = new TaskResponseDto();
        dto.setId(task.getId());
        dto.setTaskName(task.getTaskName());
        dto.setTaskDescription(task.getTaskDescription());
        dto.setCreateDate(task.getCreateDate());
        dto.setLastUpdate(task.getLastUpdate());
        dto.setDeadline(task.getDeadline());
        dto.setStatus(task.getStatus());

        return dto;

    }
}
