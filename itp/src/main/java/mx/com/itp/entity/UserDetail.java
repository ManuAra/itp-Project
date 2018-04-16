package mx.com.itp.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.com.itp.entity.UserProject.ProjectType;

@Entity
@Table(name="users_detail")
public class UserDetail {

	@Id
	@Column(name="id")	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="current_situation" , columnDefinition="ENUM('Student', 'Graduated')")
	private CurrentSituation currentSituation;
	
	@Enumerated(EnumType.STRING)
	@Column(name="experience" , columnDefinition="ENUM('Internship', 'Professional')")
	private Experience experience;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="bio")
	private String bio;
	
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name="image")
	private byte[] image;
	
	@OneToMany(mappedBy="userDetail",
				cascade= CascadeType.ALL)
	private List<UserProject> userProjects;

	@OneToMany(mappedBy="userDetail",
				cascade= CascadeType.ALL)
	private List<UserExperience> userExperiences;
	
	@OneToMany(mappedBy="userDetail",
				cascade= CascadeType.ALL)
	private List<UserSkill> userSkills;
	
	public enum CurrentSituation {
		Student, Graduated;
	};
	
	public enum Experience {
		Internship, Professional;
	};
	
	public UserDetail() {
		
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CurrentSituation getCurrentSituation() {
		return currentSituation;
	}

	public void setCurrentSituation(CurrentSituation currentSituation) {
		this.currentSituation = currentSituation;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<UserProject> getUserProjects() {
		return userProjects;
	}

	public void setUserProjects(List<UserProject> userProjects) {
		this.userProjects = userProjects;
	}

	public List<UserExperience> getUserExperiences() {
		return userExperiences;
	}

	public void setUserExperiences(List<UserExperience> userExperiences) {
		this.userExperiences = userExperiences;
	}

	public List<UserSkill> getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(List<UserSkill> userSkills) {
		this.userSkills = userSkills;
	}

	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", currentSituation=" + currentSituation + ", experience=" + experience + ", username=" + username
				+ ", email=" + email + ", bio=" + bio + ", image=" + Arrays.toString(image) + ", userProjects="
				+ userProjects + ", userExperiences=" + userExperiences + ", userSkills=" + userSkills + "]";
	}

}
