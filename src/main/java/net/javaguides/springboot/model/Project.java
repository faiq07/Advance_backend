package net.javaguides.springboot.model;


import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name ="Projects")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="project_id")
	private int ProjectId;
	
	@Column(name="manager_id")
	private int ManagerId;
	
	@Column(name="start_date")
	private Date StartDate;
	
	@Column(name="due_date")
	private Date DueDate;
	
	@Column(name="project_description")
	private String ProjectDescription;
	
	@Column(name="project_status")
	private String ProjectStatus;
	
	@Column(name="project_link")
	private String ProjectLink;

	public int getProjectId() {
		return ProjectId;
	}

	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}

	public int getManagerId() {
		return ManagerId;
	}

	public void setManagerId(int managerId) {
		ManagerId = managerId;
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

	public String getProjectDescription() {
		return ProjectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		ProjectDescription = projectDescription;
	}

	public String getProjectStatus() {
		return ProjectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		ProjectStatus = projectStatus;
	}

	public String getProjectLink() {
		return ProjectLink;
	}

	public void setProjectLink(String projectLink) {
		ProjectLink = projectLink;
	}

	public Project(int projectId, int managerId, Date startDate, Date dueDate, String projectDescription,
			String projectStatus, String projectLink) {
		super();
		ProjectId = projectId;
		ManagerId = managerId;
		StartDate = startDate;
		DueDate = dueDate;
		ProjectDescription = projectDescription;
		ProjectStatus = projectStatus;
		ProjectLink = projectLink;
	}
	
	public Project()
	{
		
	}
	public void copyProject(Project obj)
	{
		this.ManagerId= obj.getManagerId();
		this.ProjectId= obj.getProjectId();
		this.StartDate= obj.getStartDate();
		this.DueDate= obj.getDueDate();
		this.ProjectDescription= obj.getProjectDescription();
		this.ProjectStatus= obj.getProjectStatus();
		this.ProjectLink= obj.getProjectLink();
	}
	
}
