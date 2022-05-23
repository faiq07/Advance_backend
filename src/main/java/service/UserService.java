package service;

import java.util.*;
import net.javaguides.springboot.model.User;

public interface UserService {
	public Integer saveUser(User user);
	public List<User> getAllUsers();
	public User getUserbyId(Integer uno);
	public void deleteUser(Integer uno);

}
