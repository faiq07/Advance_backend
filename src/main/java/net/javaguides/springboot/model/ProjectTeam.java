package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ProjectTeam")
public class ProjectTeam {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="project_id")
	private int ProjectId;
	
	@Column(name="manager_id")
	private int ManagerId;
	
	@Column(name="employee_id")
	private int EmployeeId;

	public ProjectTeam(int projectId, int managerId, int employeeId) {
		super();
		ProjectId = projectId;
		ManagerId = managerId;
		EmployeeId = employeeId;
	}

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

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public void copyProjectTeam(ProjectTeam obj)
	{
		this.EmployeeId= obj.getEmployeeId();
		this.ManagerId= obj.getManagerId();
		this.ProjectId= obj.getProjectId();
	}
}
