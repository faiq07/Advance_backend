package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.javaguides.springboot.model.Task;

public interface TaskRepository extends JpaRepository<Task,Integer>, CrudRepository<Task, Integer>{

}
