package org.group39fsworkingproject.repository;

import org.group39fsworkingproject.entity.Manager;
import org.group39fsworkingproject.entity.Task;
import org.group39fsworkingproject.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByTaskName(String taskName);

    List<Task> findByManager(Manager manager);

    List<Task> findByStatus(TaskStatus status);


}
