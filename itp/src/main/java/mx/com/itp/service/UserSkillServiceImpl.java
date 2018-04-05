package mx.com.itp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.itp.dao.UserSkillDAO;
import mx.com.itp.entity.UserSkill;

@Service
public class UserSkillServiceImpl implements UserSkillService {

	@Autowired
	private UserSkillDAO userSkillDAO;

	@Override
	@Transactional
	public List<UserSkill> getUserSkillsById( int userDetailuserId) {
		
		return userSkillDAO.getUserSkillsById(userDetailuserId);
		
	}

	@Override
	@Transactional
	public void saveUserSkill(UserSkill theUserSkill) {
		
		userSkillDAO.saveUserSkill(theUserSkill);
		
	}

	@Override
	@Transactional
	public void deleteSkill(int skillId) {
		
		userSkillDAO.deleteSkill(skillId);
		
	}
	
	
}
