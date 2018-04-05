package mx.com.itp.entity;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_file")
public class ProjectFile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int fileId;
	
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name="project_file")
	private byte[] projectFile;
	
	@OneToOne(mappedBy="projectFile")
	private UserProject userProject;
	
	public ProjectFile() {
		
	}
	
	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public byte[] getProjectFile() {
		return projectFile;
	}

	public void setProjectFile(byte[] projectFile) {
		this.projectFile = projectFile;
	}

	public UserProject getUserProject() {
		return userProject;
	}

	public void setUserProject(UserProject userProject) {
		this.userProject = userProject;
	

	

}

	@Override
	public String toString() {
		return "ProjectFile [fileId=" + fileId + ", projectFile=" + Arrays.toString(projectFile) + ", userProject="
				+ userProject + "]";
	}
	
}
