package mx.com.itp.dao;

import java.util.List;

import mx.com.itp.entity.UserExperience;

public interface UserExperienceDAO {

	public List<UserExperience> getUserExperiences(int userDetailuserId);

	public void saveUserExperience(UserExperience theUserExperience);

	public UserExperience getUserExperience(int userId);

	public void deleteUserExperience(int theId);



}
