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
import net.javaguides.springboot.model.Task;
import net.javaguides.springboot.repository.TaskRepository;

@RestController
@RequestMapping("/Task")
public class TaskController {
	
	@Autowired
	private TaskRepository taskservice;
	
	@GetMapping("/getAllTask")
	public @ResponseBody List<Task> getAllManagers(){
		return this.taskservice.findAll();
	}
	
	@PostMapping("/saveTask")
	public ResponseEntity<String> saveproject(@RequestBody Task task)
	{
		this.taskservice.save(task);
		return new ResponseEntity<String>("Task Created", HttpStatus.OK);
		
	}
	@GetMapping("/TaskList")
	public ResponseEntity<List<Task>> getAllTaskDetails()
	{
		List<Task> list= taskservice.findAll();
		return new ResponseEntity<List<Task>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getTaskById/{taskId}")
	public ResponseEntity<Task> getProjectById(@PathVariable("taskId")Integer taskId)
	{
		Task us=taskservice.getById(taskId);
		return new ResponseEntity<Task>(us, HttpStatus.OK);
	}
	@PutMapping("/updateTask/{taskId}")
	public ResponseEntity<String> updateProject(@PathVariable("taskId") Integer taskId,@RequestBody Task task)
	{
		Task tempFromDB=taskservice.getById(taskId);
		tempFromDB.copyTask(task);
		taskservice.save(tempFromDB);
		return new ResponseEntity<String>("Task Updated", HttpStatus.OK);
	}
	@DeleteMapping("/deleteTask/{taskId}")
	public ResponseEntity<String> deleteTask(@PathVariable("taskId") Integer taskId)
	{
		taskservice.deleteById(taskId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

}
