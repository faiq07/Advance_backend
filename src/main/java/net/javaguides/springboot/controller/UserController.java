package net.javaguides.springboot.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springboot.model.SignIn;
import net.javaguides.springboot.model.Task;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.TaskRepository;
import net.javaguides.springboot.repository.UserRepository;
import service.UserSerivceImp;
import service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private UserRepository userservice;
	@Autowired
	private TaskController taskservice;
	//private UserService service= new UserSerivceImp();
	@GetMapping("/Persons")
	public @ResponseBody List<User> getUsers(){
		
		return this.userservice.findAll();
	}
	
	
	@PostMapping("/saveuser")
	public ResponseEntity<Integer> saveuser(@RequestBody User user)
	{
		System.out.println(user.toString());
		this.userservice.save(user);
		
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
		
	}
	
	@GetMapping("/userList")
	public ResponseEntity<List<User>> getAllUserDetails()
	{
		List<User> list= userservice.findAll();
		for(User i: list)
		{
			i.print();
		}
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getUserById/{PersonId}")
	public ResponseEntity<User> getUserById(@PathVariable("PersonId")Integer PersonId)
	{
		User us=userservice.getById(PersonId);
		return new ResponseEntity<User>(us, HttpStatus.OK);
	}
	@PutMapping("/updateUser/{PersonId}")
	public ResponseEntity<String> updateUser(@PathVariable("PersonId") Integer PersonId,@RequestBody User user)
	{
		User tempFromDB=userservice.getById(PersonId);
		tempFromDB.copy(user);
		userservice.save(tempFromDB);
		return new ResponseEntity<String>("User Updated", HttpStatus.OK);
	}
	@DeleteMapping("/deleteUser/{PersonId}")
	public ResponseEntity<String> deleteUser(@PathVariable("PersonId") Integer PersonId)
	{
		userservice.deleteById(PersonId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	
	@PostMapping("/checkforlogin")
	@CrossOrigin
	public ResponseEntity<Integer> validation(@RequestBody SignIn obj){
		obj.print();
		List<User> temp= this.getUsers();
		int check=-1;
		for (User o: temp)
		{
			if(o.getEmail().equals(obj.getEmail()) && o.getPassword().equals(obj.getPass()))
			{
				check=o.getPersonId();
			}
		}
		
		return new ResponseEntity<Integer>(check, HttpStatus.OK);
	}
}
