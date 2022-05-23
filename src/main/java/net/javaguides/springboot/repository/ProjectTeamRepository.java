package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.javaguides.springboot.model.ProjectTeam;

public interface ProjectTeamRepository extends JpaRepository<ProjectTeam,Integer>, CrudRepository<ProjectTeam, Integer> {

}
