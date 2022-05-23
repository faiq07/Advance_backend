package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.controller.UserController;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

@Service
public class UserSerivceImp implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		Integer id=0;
		try {
			id=userRepository.save(user).getPersonId();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>)userRepository.findAll();
	}

	@Override
	public User getUserbyId(Integer uno) {
		// TODO Auto-generated method stub
		return userRepository.findById(uno).get();
	}

	@Override
	public void deleteUser(Integer uno) {
		userRepository.deleteById(uno);
		
	}

}
