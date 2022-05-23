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
import net.javaguides.springboot.model.Manager;
import net.javaguides.springboot.repository.ManagerRepository;

@RestController
@RequestMapping("/Manager")
public class ManagerController {
	
	@Autowired
	private ManagerRepository managerservice;
	
	@GetMapping("/getAllmanagers")
	public @ResponseBody List<Manager> getAllManagers(){
		return this.managerservice.findAll();
	}
	
	@PostMapping("/savemanaer")
	public ResponseEntity<String> saveuser(@RequestBody Manager manager)
	{
		this.managerservice.save(manager);
		return new ResponseEntity<String>("User Created", HttpStatus.OK);
		
	}
	@GetMapping("/managerList")
	public ResponseEntity<List<Manager>> getAllUserDetails()
	{
		List<Manager> list= managerservice.findAll();
		return new ResponseEntity<List<Manager>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getmanagerById/{ManagerId}")
	public ResponseEntity<Manager> getUserById(@PathVariable("ManagerId")Integer ManagerId)
	{
		Manager us=managerservice.getById(ManagerId);
		return new ResponseEntity<Manager>(us, HttpStatus.OK);
	}
	@PutMapping("/updateManager/{ManagerId}")
	public ResponseEntity<String> updateManager(@PathVariable("ManagerId") Integer ManagerId,@RequestBody Manager manager)
	{
		Manager tempFromDB=managerservice.getById(ManagerId);
		tempFromDB.copyManager(manager);
		managerservice.save(tempFromDB);
		return new ResponseEntity<String>("Manager Updated", HttpStatus.OK);
	}
	@DeleteMapping("/deleteManager/{ManagerId}")
	public ResponseEntity<String> deleteManager(@PathVariable("ManagerId") Integer ManagerId)
	{
		managerservice.deleteById(ManagerId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
}
