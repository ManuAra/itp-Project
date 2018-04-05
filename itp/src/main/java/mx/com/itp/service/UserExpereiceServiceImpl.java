package mx.com.itp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.itp.dao.UserExperienceDAO;
import mx.com.itp.entity.UserExperience;

@Service
public class UserExpereiceServiceImpl implements UserExperienceService {

	@Autowired
	private UserExperienceDAO userExperienceDAO;

	@Override
	@Transactional
	public List<UserExperience> getUserExperiences(int userDetailuserId) {
		
		return userExperienceDAO.getUserExperiences(userDetailuserId);
	}

	@Override
	@Transactional
	public void saveUserExperience(UserExperience theUserExperience) {
		
		userExperienceDAO.saveUserExperience(theUserExperience);
		
	}

	@Override
	@Transactional
	public UserExperience getUserExperience(int userId) {
		
		return userExperienceDAO.getUserExperience(userId);
	}

	@Override
	@Transactional
	public void deleteUserExperience(int theId) {
		
		userExperienceDAO.deleteUserExperience(theId);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
