package net.javaguides.springboot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="project_id")
	private int ProjectId;
	
	@Column(name="task_id")
	private int taskId;
	
	@Column(name="start_date")
	private Date StartDate;
	
	@Column(name="due_date")
	private Date DueDate;
	
	@Column(name="task_description")
	private String TaskDescription;

	@Column(name="task_assignedTo")
	private String TaskAssignedTo;
	
	@Column(name="task_status")
	private String TaskStatus;
	
	@Column(name="task_link")
	private String TaskLink;

	public Task(int projectId, int taskId, Date startDate, Date dueDate, String taskDescription, String taskAssignedTo,
			String taskStatus, String taskLink) {
		super();
		ProjectId = projectId;
		this.taskId = taskId;
		StartDate = startDate;
		DueDate = dueDate;
		TaskDescription = taskDescription;
		TaskAssignedTo = taskAssignedTo;
		TaskStatus = taskStatus;
		TaskLink = taskLink;
	}

	public int getProjectId() {
		return ProjectId;
	}

	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getDueDate() {
		return DueDate;
	}

	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}

	public String getTaskDescription() {
		return TaskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		TaskDescription = taskDescription;
	}

	public String getTaskAssignedTo() {
		return TaskAssignedTo;
	}

	public void setTaskAssignedTo(String taskAssignedTo) {
		TaskAssignedTo = taskAssignedTo;
	}

	public String getTaskStatus() {
		return TaskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		TaskStatus = taskStatus;
	}

	public String getTaskLink() {
		return TaskLink;
	}

	public void setTaskLink(String taskLink) {
		TaskLink = taskLink;
	}
	
	public void copyTask(Task obj)
	{
		this.ProjectId= obj.getProjectId();
		this.taskId= obj.getTaskId();
		this.DueDate= obj.getDueDate();
		this.StartDate= obj.getStartDate();
		this.TaskAssignedTo= obj.getTaskAssignedTo();
		this.TaskDescription= obj.getTaskDescription();
		this.TaskLink= obj.getTaskLink();
		this.TaskStatus= obj.getTaskStatus();
	}
}
