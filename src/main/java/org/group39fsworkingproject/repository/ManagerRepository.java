package org.group39fsworkingproject.repository;

import org.group39fsworkingproject.entity.Manager;
import org.group39fsworkingproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Optional<Manager> findByEmail(String email);
    List<Manager> findByManagerName(String managerName);
    List<Manager> findByRole(Role role);
}
