package mx.com.itp.service;

import java.util.List;

import mx.com.itp.entity.UserSkill;

public interface UserSkillService {

	public List<UserSkill> getUserSkillsById(int userDetailuserId);

	public void saveUserSkill(UserSkill theUserSkill);

	public void deleteSkill(int skillId);

}
