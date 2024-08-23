package org.group39fsworkingproject.service.util;

import org.group39fsworkingproject.dto.managerDto.ManagerCreateRequestDto;
import org.group39fsworkingproject.dto.managerDto.ManagerCreateResponseDto;
import org.group39fsworkingproject.dto.managerDto.ManagerResponseDto;
import org.group39fsworkingproject.entity.Manager;
import org.springframework.stereotype.Component;

@Component
public class ManagerConverter {

    public Manager fromDto(ManagerCreateRequestDto dto){
        Manager manager = new Manager();
        manager.setManagerName(dto.getManagerName());
        manager.setEmail(dto.getEmail());
        manager.setPassword(dto.getPassword());
        return manager;
    }

    public ManagerCreateResponseDto toCreateDto(Manager manager){
        return new ManagerCreateResponseDto(
                manager.getId(),
                manager.getManagerName(),
                manager.getRole().getName());
    }

    public ManagerResponseDto toDto(Manager manager){
        return new ManagerResponseDto(
                manager.getId(),
                manager.getManagerName(),
                manager.getEmail(),
                manager.getRole().getName());
    }
}
