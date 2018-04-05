package mx.com.itp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import mx.com.itp.entity.UserSkill;

@Repository
public class UserSkillDAOImpl implements UserSkillDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserSkill> getUserSkillsById( int userDetailuserId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<UserSkill> theQuery = 
							currentSession.createQuery("from UserSkill where user_id=:userDetailuserId", UserSkill.class);
		
		theQuery.setParameter("userDetailuserId", userDetailuserId);
		
		List<UserSkill> theUserSkills = theQuery.getResultList();
		
		return theUserSkills;
	}

	@Override
	public void saveUserSkill(UserSkill theUserSkill) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theUserSkill);
		
	}

	@Override
	public void deleteSkill(int skillId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery =
					currentSession.createQuery("delete from UserSkill where id=:skillId");
		
		theQuery.setParameter("skillId",skillId);
		
		theQuery.executeUpdate();
		
	}
	
}
