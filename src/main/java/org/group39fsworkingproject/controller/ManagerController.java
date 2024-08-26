package org.group39fsworkingproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.group39fsworkingproject.dto.Response;
import org.group39fsworkingproject.dto.managerDto.ManagerCreateRequestDto;
import org.group39fsworkingproject.dto.managerDto.ManagerCreateResponseDto;
import org.group39fsworkingproject.dto.managerDto.ManagerResponseDto;
import org.group39fsworkingproject.entity.Manager;
import org.group39fsworkingproject.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/managers")
public class ManagerController {
    private final ManagerService service;

    @PostMapping
    public ResponseEntity<ManagerCreateResponseDto> createNewManager(@Valid @RequestBody ManagerCreateRequestDto request){
        return new ResponseEntity(service.createManager(request),HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ManagerResponseDto>> findAll(){
        return  new ResponseEntity(service.findAll(), HttpStatus.OK);
    }


    @GetMapping("/full")
    public ResponseEntity<List<Manager>> findAllFull(){
        return new ResponseEntity(service.findFullManagerDetails(),HttpStatus.FOUND);
    }

    @GetMapping("/email")
    public ResponseEntity<ManagerResponseDto> findByEmail(@RequestParam String email){
        return ResponseEntity.ok(service.findManagerByEmail(email));
    }


}
