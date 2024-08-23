package org.group39fsworkingproject.service;

import lombok.RequiredArgsConstructor;
import org.group39fsworkingproject.dto.Response;
import org.group39fsworkingproject.dto.managerDto.ManagerCreateRequestDto;
import org.group39fsworkingproject.dto.managerDto.ManagerCreateResponseDto;
import org.group39fsworkingproject.dto.managerDto.ManagerResponseDto;
import org.group39fsworkingproject.entity.Manager;
import org.group39fsworkingproject.entity.Role;
import org.group39fsworkingproject.repository.ManagerRepository;
import org.group39fsworkingproject.repository.RoleRepository;
import org.group39fsworkingproject.service.exception.AlreadyExistException;
import org.group39fsworkingproject.service.exception.NotFoundException;
import org.group39fsworkingproject.service.util.ManagerConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ManagerService {
    private final ManagerRepository repository;
    private final RoleRepository roleRepository;
    private final ManagerConverter converter;


    public ManagerCreateResponseDto createManager(ManagerCreateRequestDto request){

            if (repository.findByEmail(request.getEmail()).isEmpty()) {
                Manager newManager = converter.fromDto(request);

                // Role newManagerRole = new Role(1,"USER"); - не работает для связи данных между таблицами

                Optional<Role> defaultRole = roleRepository.findByName("USER");

                if (defaultRole.isPresent()) {
                    newManager.setRole(defaultRole.get());
                } else {
                    throw new NotFoundException("Role 'USER' not found");
                }

                Manager savedManager = repository.save(newManager);

                return converter.toCreateDto(savedManager);

            } else {
                throw new AlreadyExistException("Manager with email " + request.getEmail() + " is already exist");
            }

    }


    public ManagerResponseDto findManagerByEmail(String email){
        Optional<Manager> managerOptional = repository.findByEmail(email);

        if (managerOptional.isPresent()) {
            ManagerResponseDto response = converter.toDto(managerOptional.get());
            return response;
        } else  {
            throw new NotFoundException("Manager with email " + email + " not found");
        }
    }


    public List<ManagerResponseDto> findAll(){
        return repository.findAll().stream()
                .map(manager -> converter.toDto(manager))
                .toList();
    }

    public List<Manager> findFullManagerDetails(){
        return repository.findAll();
    }

    public Manager findManagerByEmailForCreateTask(String email){
        Optional<Manager> managerOptional = repository.findByEmail(email);

        if (managerOptional.isPresent()) {
            return managerOptional.get();
        } else  {
            throw new NotFoundException("Manager with email " + email + " not found");
        }
    }

}
