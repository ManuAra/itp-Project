package mx.com.itp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.com.itp.entity.UserExperience;

@Repository
public class UserExperienceDAOImpl implements UserExperienceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	//experimento time "from UserExperience order by experienceId"
	@Override
	public List<UserExperience> getUserExperiences(int userDetailuserId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<UserExperience> theQuery = 
								currentSession.createQuery("from UserExperience where user_id=:userDetailuserId", 
															UserExperience.class);
		
		theQuery.setParameter("userDetailuserId", userDetailuserId);
		
		List<UserExperience> theExperiences = theQuery.getResultList();
		
		return theExperiences;
	}

	@Override
	public void saveUserExperience(UserExperience theUserExperience) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theUserExperience);
		
	}

	@Override
	public UserExperience getUserExperience(int userId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		UserExperience theUserExperience = currentSession.get(UserExperience.class, userId);
		
		return theUserExperience;
	}

	@Override
	public void deleteUserExperience(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery =
						currentSession.createQuery("delete from UserExperience where id=:experienceId");
		
		theQuery.setParameter("experienceId", theId);
		
		theQuery.executeUpdate();
		
	}
	
	
}
