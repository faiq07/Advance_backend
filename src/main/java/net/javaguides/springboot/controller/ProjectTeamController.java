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

import net.javaguides.springboot.model.ProjectTeam;
import net.javaguides.springboot.repository.ProjectTeamRepository;

@RestController
@RequestMapping("/ProjectTeam")
public class ProjectTeamController {
	
	@Autowired
	private ProjectTeamRepository projectteamservice;
	
	@GetMapping("/getAllProjectTeam")
	public @ResponseBody List<ProjectTeam> getAllManagers(){
		return this.projectteamservice.findAll();
	}
	
	@PostMapping("/saveProjectTeam")
	public ResponseEntity<String> saveproject(@RequestBody ProjectTeam project)
	{
		this.projectteamservice.save(project);
		return new ResponseEntity<String>("Project Team Registered", HttpStatus.OK);
		
	}
	@GetMapping("/ProjectTeamList")
	public ResponseEntity<List<ProjectTeam>> getAllProjectDetails()
	{
		List<ProjectTeam> list= this.projectteamservice.findAll();
		return new ResponseEntity<List<ProjectTeam>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getProjectTeamById/{ProjectId}")
	public ResponseEntity<ProjectTeam> getProjectById(@PathVariable("ProjectId")Integer ProjectId)
	{
		ProjectTeam us=this.projectteamservice.getById(ProjectId);
		return new ResponseEntity<ProjectTeam>(us, HttpStatus.OK);
	}
	@PutMapping("/updateProjectTeam/{ProjectId}")
	public ResponseEntity<String> updateProject(@PathVariable("ProjectId") Integer ProjectId,@RequestBody ProjectTeam project)
	{
		ProjectTeam tempFromDB=this.projectteamservice.getById(ProjectId);
		tempFromDB.copyProjectTeam(project);
		this.projectteamservice.save(tempFromDB);
		return new ResponseEntity<String>("Project Team Updated", HttpStatus.OK);
	}
	@DeleteMapping("/deleteProjectTeam/{ProjectId}")
	public ResponseEntity<String> deleteManager(@PathVariable("ProjectId") Integer ProjectId)
	{
		this.projectteamservice.deleteById(ProjectId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}


}
