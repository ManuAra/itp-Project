package mx.com.itp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.itp.dao.UserProjectDAO;
import mx.com.itp.entity.ProjectFile;
import mx.com.itp.entity.UserProject;

@Service
public class UserProjectServiceImpl implements UserProjectService {

	@Autowired
	private UserProjectDAO userProjectDAO;

	@Override
	@Transactional
	public List<UserProject> getAllProjectsById(int userDetailuserId) {
		
		return userProjectDAO.getAllProjectsById(userDetailuserId);
	
	}

	@Override
	@Transactional
	public void saveProject(UserProject theProject) {
		
		userProjectDAO.saveProject(theProject);
		
	}

	@Override
	@Transactional
	public UserProject getUserProject(int tempUserProjectprojectId) {
		
		return userProjectDAO.getUserProject(tempUserProjectprojectId);
	}

	@Override
	@Transactional
	public void saveProjectFile(UserProject theUserProject) {
		
		userProjectDAO.saveProjectFile(theUserProject);
		
	}

	@Override
	@Transactional
	public void saveProjectDetail(UserProject theUserProject) {
		
		userProjectDAO.saveProjectDetail(theUserProject);
		
	}

	@Override
	@Transactional
	public ProjectFile getProjectFileById(int tempProjectFilefileId) {
		
		return userProjectDAO.getProjectFileById(tempProjectFilefileId);
		
	}

	@Override
	@Transactional
	public void delteUserProject(int projectId) {
		
		userProjectDAO.deleteUserProject(projectId);
		
	}

	@Override
	@Transactional
	public UserProject getUserProjectById(int projectId) {
		
		return userProjectDAO.getUserProjectById(projectId);
	}
	
	
	
}
