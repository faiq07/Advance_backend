package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.javaguides.springboot.model.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer>, CrudRepository<Project, Integer>{

}
