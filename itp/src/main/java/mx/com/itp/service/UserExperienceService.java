package mx.com.itp.service;

import java.util.List;

import mx.com.itp.entity.UserExperience;

public interface UserExperienceService {

	public List<UserExperience> getUserExperiences(int userDetailuserId) ;

	public void saveUserExperience(UserExperience theUserExperience);

	public UserExperience getUserExperience(int userId);

	public void deleteUserExperience(int theId);

	

}
