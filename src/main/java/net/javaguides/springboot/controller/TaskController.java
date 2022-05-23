package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.repository.TaskRepository;

@RestController
@RequestMapping("/Task")
public class TaskController {
	
	@Autowired
	private TaskRepository taskservice;

}
