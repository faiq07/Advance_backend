package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.javaguides.springboot.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager,Integer>, CrudRepository<Manager, Integer>{

}
