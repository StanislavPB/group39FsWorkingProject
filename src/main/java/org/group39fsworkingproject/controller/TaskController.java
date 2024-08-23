package org.group39fsworkingproject.controller;

import lombok.RequiredArgsConstructor;
import org.group39fsworkingproject.dto.managerDto.ManagerCreateRequestDto;
import org.group39fsworkingproject.dto.managerDto.ManagerCreateResponseDto;
import org.group39fsworkingproject.dto.managerDto.ManagerResponseDto;
import org.group39fsworkingproject.dto.taskDto.TaskCreateRequestDto;
import org.group39fsworkingproject.dto.taskDto.TaskCreateResponseDto;
import org.group39fsworkingproject.dto.taskDto.TaskResponseDto;
import org.group39fsworkingproject.entity.Manager;
import org.group39fsworkingproject.entity.Task;
import org.group39fsworkingproject.service.ManagerService;
import org.group39fsworkingproject.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    @PostMapping
    public ResponseEntity<TaskCreateResponseDto> createNewTask(@RequestBody TaskCreateRequestDto request){
        return new ResponseEntity<>(service.createTask(request), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/full")
    public ResponseEntity<List<Task>> findAllFull(){
        return ResponseEntity.ok(service.findAllFullTaskDetails());
    }

}
