package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>, CrudRepository<User, Integer> {

	//Optional<User> findByUsername(String username);
	//Boolean existsByUsername(String name);
	//Boolean existsByEmail(String email);
	//Optional<User> findByEmailContainingAndPasswordContaining(String email, String pass);
	
	//User findOne(int id);
	//void delete(int id);
}
