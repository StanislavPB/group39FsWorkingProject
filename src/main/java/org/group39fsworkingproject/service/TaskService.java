package org.group39fsworkingproject.service;

import lombok.RequiredArgsConstructor;
import org.group39fsworkingproject.dto.taskDto.TaskCreateRequestDto;
import org.group39fsworkingproject.dto.taskDto.TaskCreateResponseDto;
import org.group39fsworkingproject.dto.taskDto.TaskResponseDto;
import org.group39fsworkingproject.entity.Manager;
import org.group39fsworkingproject.entity.Task;
import org.group39fsworkingproject.entity.TaskStatus;
import org.group39fsworkingproject.repository.TaskRepository;
import org.group39fsworkingproject.service.util.TaskConverter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskConverter converter;
    private final ManagerService service;


    public List<TaskResponseDto> findAll(){

        return taskRepository.findAll().stream()
                .map(converter::toDto)
                .toList();
    }

    public TaskCreateResponseDto createTask(TaskCreateRequestDto request){

        Task newTask = converter.fromCreateRequest(request);

        newTask.setCreateDate(LocalDateTime.now());
        newTask.setLastUpdate(LocalDateTime.now());
        newTask.setStatus(TaskStatus.OPEN);

        Manager manager = service.findManagerByEmailForCreateTask(request.getManagerEmail());
        newTask.setManager(manager);

        Task savedTask = taskRepository.save(newTask);

        return converter.toCreateDto(savedTask);

    }


    // получить список задач по менеджеру

    public List<TaskResponseDto> findTaskByManagerEmail(String managerEmail){

        Manager managerForSearch = service.findManagerByEmailForCreateTask(managerEmail);

        // List<Task> managerTasks = managerForSearch.getTasks(); // 1 вариант

        return taskRepository.findByManager(managerForSearch).stream()
                .map(converter::toDto)
                .toList();

    }


    public List<Task> findAllFullTaskDetails(){
        return taskRepository.findAll();
    }

}
