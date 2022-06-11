package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Manager")
public class Manager {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	
	@Column(name="manager_id")
	private int ManagerId;
	
	@Column(name="project_id")
	private int ProjectId;
	
	

	public Manager(int projectId, int managerId) {
		super();
		ProjectId = projectId;
		ManagerId = managerId;
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
	
	public void copyManager(Manager obj)
	{
		this.ManagerId= obj.getManagerId();
		this.ProjectId= obj.getProjectId();
	}
	public Manager()
	{
		
	}
}
