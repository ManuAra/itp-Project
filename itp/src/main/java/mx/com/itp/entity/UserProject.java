package mx.com.itp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class UserProject {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int projectId;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private UserDetail userDetail;
	
	@JoinColumn(name="course")
	private String course;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="project_file_id")
	private ProjectFile projectFile;
	
	@Column(name="project_title")
	private String projectTitle;
	
	@Enumerated(EnumType.STRING)
	@Column(name="project_type" , columnDefinition="ENUM('personal','school')")
	private ProjectType projectType;
	
	@Column(name="project_description")
	private String projectDescription;
	
	public UserProject() {
		
	}
	
	public enum ProjectType {
		personal,school;
	};
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public ProjectFile getProjectFile() {
		return projectFile;
	}

	public void setProjectFile(ProjectFile projectFile) {
		this.projectFile = projectFile;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	@Override
	public String toString() {
		return "UserProject [projectId=" + projectId + ", userDetail=" + userDetail + ", course=" + course
				+ ", projectFile=" + projectFile + ", projectTitle=" + projectTitle
				+ ", projectType=" + projectType + ", projectDescription=" + projectDescription + "]";
	}

}
