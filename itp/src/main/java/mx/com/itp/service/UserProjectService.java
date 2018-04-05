package mx.com.itp.service;

import java.util.List;

import mx.com.itp.entity.ProjectFile;
import mx.com.itp.entity.UserProject;

public interface UserProjectService {

	public List<UserProject> getAllProjectsById(int userDetailuserId);

	public void saveProject(UserProject theProject);

	public UserProject getUserProject(int tempUserProjectprojectId);

	public void saveProjectFile(UserProject theUserProject);

	public void saveProjectDetail(UserProject theUserProject);

	public ProjectFile getProjectFileById(int tempProjectFilefileId);

	public void delteUserProject(int projectId);

	public UserProject getUserProjectById(int projectId);

}
