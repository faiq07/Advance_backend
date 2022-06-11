package net.javaguides.springboot.model;


import javax.persistence.*;

@Entity
@Table(name ="Project")
public class Project {
		
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;

	@Column(name="project_id")
	private int ProjectId;
	
	@Column(name="person_id")
	private int ManagerId;
	
	@Column(name="project_title")
	private String ProjectTitle;
	
	@Column(name="projectx_type")
	private String ProjectType;
	
	@Column(name="start_date")
	private String StartDate;
	
	@Column(name="due_date")
	private String DueDate;
	
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

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getDueDate() {
		return DueDate;
	}

	public void setDueDate(String dueDate) {
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


	
	public Project(int projectId, int managerId, String projectTitle, String projectType, String startDate,
			String dueDate, String projectDescription, String projectStatus, String projectLink) {
		super();
		ProjectId = projectId;
		ManagerId = managerId;
		ProjectTitle = projectTitle;
		ProjectType = projectType;
		StartDate = startDate;
		DueDate = dueDate;
		ProjectDescription = projectDescription;
		ProjectStatus = projectStatus;
		ProjectLink = projectLink;
	}
	
	public String getProjectTitle() {
		return ProjectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		ProjectTitle = projectTitle;
	}

	public String getProjectType() {
		return ProjectType;
	}

	public void setProjectType(String projectType) {
		ProjectType = projectType;
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
		this.ProjectTitle= obj.getProjectTitle();
		this.ProjectType= obj.getProjectType();
	}
	
}
