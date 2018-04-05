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
import javax.persistence.Table;

@Entity
@Table(name="experience")
public class UserExperience {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int experienceId;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private UserDetail userDetail;
	
	@Column(name="position")
	private String position;
	
	@Column(name="place")
	private String place;
	
	@Column(name="period")
	private String period;
	
	@Enumerated(EnumType.STRING)
	@Column(name="current_position" , columnDefinition="ENUM('yes','no')")
	private CurrentPosition currentPosition;
	
	@Column(name="activities")
	private String activities;
	
	public enum CurrentPosition {
		yes,no;	
	};

	public UserExperience() {
		
	}
	
	public int getExperienceId() {
		return experienceId;
	}

	public void setExperienceId(int experienceId) {
		this.experienceId = experienceId;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public CurrentPosition getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(CurrentPosition currentPosition) {
		this.currentPosition = currentPosition;
	}

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}

	@Override
	public String toString() {
		return "UserExperience [experienceId=" + experienceId + ", userDetail=" + userDetail + ", position=" + position
				+ ", place=" + place + ", period=" + period + ", currentPosition=" + currentPosition + ", activities="
				+ activities + "]";
	};
	
	
}
