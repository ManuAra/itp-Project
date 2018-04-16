package mx.com.itp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.com.itp.entity.UserDetail;

@Repository
public class UserDetailDAOImpl implements UserDetailDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserDetail> getUserDetails() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<UserDetail> theQuery =
							currentSession.createQuery("from UserDetail order by userId", UserDetail.class);
		
		List<UserDetail> theUserDetails = theQuery.getResultList();
		
		return theUserDetails;
	}

	@Override
	public void saveUserDetail(UserDetail theUserDetail) {
		
		Session currentSession =sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theUserDetail);
		
	}

	@Override
	public UserDetail getUserDetail(int userId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		UserDetail theUserDetail = currentSession.get(UserDetail.class, userId);
		
		return theUserDetail;
	}

	@Override
	public void deleteUserDetail(int userId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery =
					currentSession.createQuery("delete from UserDetail where id=:userId");
		
		theQuery.setParameter("userId", userId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<UserDetail> searchUser(String searchName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<UserDetail> theQuery = null;
		
		//Search if the name its not empty
		if (searchName!=null&& searchName.trim().length()>0) {
			
			//search for first name or last name case insensitive
			theQuery= currentSession.createQuery("from UserDetail where lower(firstName) like:Name or lower(lastName) like:Name", 
												UserDetail.class);
			
			theQuery.setParameter("Name", "%" +searchName.toLowerCase()+ "%");
		} else {
			//if empty get all the customers
			theQuery = currentSession.createQuery("from UserDetail", UserDetail.class);
		}
		
		List<UserDetail> userDetails = theQuery.getResultList();
		
		return userDetails;
	}
	
	
	
	
	
	
}
