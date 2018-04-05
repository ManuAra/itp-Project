package mx.com.itp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.com.itp.entity.ProjectFile;
import mx.com.itp.entity.UserProject;

@Repository
public class UserProjectDAOImpl implements UserProjectDAO{

	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public List<UserProject> getAllProjectsById(int userDetailuserId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<UserProject> theQuery = 
							currentSession.createQuery("from UserProject where user_id=:userDetailuserId", UserProject.class);
		
		theQuery.setParameter("userDetailuserId", userDetailuserId);
		
		List<UserProject> theProjects = theQuery.getResultList();
		
		return theProjects;
	}

	@Override
	public void saveProject(UserProject theProject) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(theProject);
	}

	@Override
	public UserProject getUserProject(int tempUserProjectprojectId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		UserProject theUserProject = currentSession.get(UserProject.class, tempUserProjectprojectId);
		
		return theUserProject;
	}

	@Override
	public void saveProjectFile(UserProject theUserProject) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theUserProject);
		
	}

	@Override
	public void saveProjectDetail(UserProject theUserProject) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theUserProject);
		
	}

	@Override
	public ProjectFile getProjectFileById(int tempProjectFilefileId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		ProjectFile theProjectFile = currentSession.get(ProjectFile.class, tempProjectFilefileId);
		
		return theProjectFile;
	}

	@Override
	public void deleteUserProject(int projectId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery =
				currentSession.createQuery("delete from UserProject where id=:projectId");

		theQuery.setParameter("projectId", projectId);

		theQuery.executeUpdate();
	}

	@Override
	public UserProject getUserProjectById(int projectId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		UserProject theUserProject = currentSession.get(UserProject.class, projectId);
		
		return theUserProject;
	}
	
	
	
	
}
