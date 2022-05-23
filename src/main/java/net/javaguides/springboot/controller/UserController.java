package net.javaguides.springboot.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userservice;
	//private UserService service= new UserSerivceImp();
	@GetMapping("/Persons")
	public @ResponseBody List<User> getUsers(){
		return this.userservice.findAll();
	}
	
	
	@PostMapping("/saveuser")
	public ResponseEntity<String> saveuser(@RequestBody User user)
	{
		this.userservice.save(user);
		user.print();
		return new ResponseEntity<String>("User Created", HttpStatus.OK);
		
	}
	
	@GetMapping("/userList")
	public ResponseEntity<List<User>> getAllUserDetails()
	{
		List<User> list= userservice.findAll();
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
	public ResponseEntity<Integer> validation(@RequestBody SignIn obj){
		List<User> temp= this.getUsers();
		int check=0;
		for (User o: temp)
		{
			if(o.getEmail().equals(obj.getEmail()) && o.getPassword().equals(obj.getPass()))
			{
				check=1;
			}
		}
		
		return new ResponseEntity<Integer>(check, HttpStatus.OK);
	}
	
	
}
