package mx.com.itp.dao;

import java.util.List;

import mx.com.itp.entity.UserSkill;

public interface UserSkillDAO {

	public List<UserSkill> getUserSkillsById( int userDetailuserId);

	public void saveUserSkill(UserSkill theUserSkill);

	public void deleteSkill(int skillId);

}
