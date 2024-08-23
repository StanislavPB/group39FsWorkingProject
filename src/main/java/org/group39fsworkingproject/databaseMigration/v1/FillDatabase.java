package org.group39fsworkingproject.databaseMigration.v1;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.group39fsworkingproject.entity.Role;
import org.group39fsworkingproject.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
//@Component
public class FillDatabase {

    private final RoleRepository repository;

    public void fillRoleTable(){
        Role admin = new Role("ADMIN");
        repository.save(admin);

        Role user = new Role("USER");
        repository.save(user);

    }

}
