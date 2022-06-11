package net.javaguides.springboot.controller;

import java.util.ArrayList;
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
import net.javaguides.springboot.model.Project;
import net.javaguides.springboot.repository.ProjectRepository;

@RestController
@RequestMapping("/Project")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectservice;
	
	@GetMapping("/getAllProject")
	public @ResponseBody List<Project> getAllManagers(){
		return this.projectservice.findAll();
	}
	
	@PostMapping("/saveProject")
	public ResponseEntity<String> saveproject(@RequestBody Project project)
	{
		this.projectservice.save(project);
		return new ResponseEntity<String>("Project Created", HttpStatus.OK);
		
	}
	@GetMapping("/ProjectList")
	public ResponseEntity<List<Project>> getAllProjectDetails()
	{
		List<Project> list= projectservice.findAll();
		return new ResponseEntity<List<Project>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getProjectById/{ProjectId}")
	public ResponseEntity<Project> getProjectById(@PathVariable("ProjectId")Integer ProjectId)
	{
		Project us=projectservice.getById(ProjectId);
		return new ResponseEntity<Project>(us, HttpStatus.OK);
	}
	@PutMapping("/updateProject/{ProjectId}")
	public ResponseEntity<String> updateProject(@PathVariable("ProjectId") Integer ProjectId,@RequestBody Project project)
	{
		Project tempFromDB=projectservice.getById(ProjectId);
		tempFromDB.copyProject(project);
		projectservice.save(tempFromDB);
		return new ResponseEntity<String>("Project Updated", HttpStatus.OK);
	}
	@DeleteMapping("/deleteProject/{ProjectId}")
	public ResponseEntity<String> deleteManager(@PathVariable("ProjectId") Integer ProjectId)
	{
		projectservice.deleteById(ProjectId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	
	public List<Project> getByManagerID(@RequestBody int managerid)
	{
		List<Project> obj=getAllManagers();
		List<Project> obj2= new ArrayList<Project>();
		for(Project p: obj)
		{
			if(p.getManagerId()==managerid)
			{
				obj2.add(p);
			}
		}
		return obj2;
		
	}
	@GetMapping("/getProjectByIds")
	public ResponseEntity<Project> getProjectByIds(@RequestBody Integer ProjectId)
	{
		List<Project> obj=getAllManagers();
		Project us= new Project();
		for(Project p: obj)
		{
			if(p.getProjectId()==ProjectId)
			{
				us.copyProject(p);
				break;
			}
		}
		return new ResponseEntity<Project>(us, HttpStatus.OK);
	}

	
}
