package mx.com.itp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import mx.com.itp.entity.FileManager;
import mx.com.itp.entity.ProjectFile;
import mx.com.itp.entity.UserDetail;
import mx.com.itp.entity.UserProject;
import mx.com.itp.service.UserProjectService;
import mx.com.itp.service.UserDetailService;

@Controller
@RequestMapping("/project")
public class UserProjectController {

	@Autowired
	private UserProjectService userProjectService;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@GetMapping("/listUserProjects-userId-{userDetailuserId}")
	public String listProjects(@PathVariable int userDetailuserId ,  Model theModel) {
		
		// retrieve ALL the projects in the db
		List<UserProject> theProjects = userProjectService.getAllProjectsById(userDetailuserId);
		theModel.addAttribute("userProjects", theProjects);
		
		return "admin-page";
	}

	@GetMapping("/formForAddProjectFile-userId-{userDetailuserId}-projectId-{projectId}")
	public String formForAddProjectFile(@PathVariable int projectId, @PathVariable int userDetailuserId,
						FileManager fileManager, Model theModel) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		UserProject theUserProject = userProjectService.getUserProject(projectId);
		theModel.addAttribute("userProject", theUserProject);
		
		//FileManager fileManager = new FileManager();
		theModel.addAttribute("fileManager", fileManager);
		
		return "project-form";
	}
	
	@GetMapping("/formForAddProjectDetail-userId-{userDetailuserId}")
	public String formForAddProjectDetail(@PathVariable int userDetailuserId, Model theModel) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		UserProject theUserProject = new UserProject();
		theModel.addAttribute("userProject", theUserProject);
		
		FileManager fileManager = new FileManager();
		theModel.addAttribute("fileManager", fileManager);
		
		return "project-form";
	}

	
	@PostMapping("/saveProjectDetail-userId-{userDetailuserId}")
	public String saveProjectDetail(@PathVariable int userDetailuserId, UserProject theUserProject,
										Model theModel) throws IOException {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		saveProjectDetail(theUserProject, theUserDetail);
			
		int projectId = theUserProject.getProjectId(); 
		
		return "redirect:formForAddProjectFile-userId-"+ userDetailuserId+"-projectId-"+projectId;
		
	}
	
	@GetMapping("/downloadProject-userId-{userDetailuserId}-projectId-{userProjectprojectId}-fileId-{projectFilefileId}")
	public String downloadProject(@PathVariable int userDetailuserId, @PathVariable int UserProjectprojectId, 
								@PathVariable int ProjectFilefileId, Model theModel, HttpServletResponse response) throws IOException {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		ProjectFile theProjectFile  = userProjectService.getProjectFileById(ProjectFilefileId);
		theModel.addAttribute("projectFile", theProjectFile);
		
		FileCopyUtils.copy(theProjectFile.getProjectFile(), response.getOutputStream());
		
		return "redirect:/userProfile/showUserProfile-userId-"+ userDetailuserId;
	}
	
	@PostMapping("/saveProjectFile-userId-{userDetailuserId}-projectId-{userProjectprojectId}")
	public String uploadProjectFile(@PathVariable int userProjectprojectId, @PathVariable int userDetailuserId,
									FileManager fileManager,  Model theModel ) throws IOException {
		
		UserProject theUserProject = userProjectService.getUserProject(userProjectprojectId);
		theModel.addAttribute("userProject", theUserProject);
		
		ProjectFile theProjectFile = new ProjectFile();
				
		saveProjectFile(fileManager, theUserProject, theProjectFile);
		
		int Id = theProjectFile.getFileId();
		
		System.out.println(">>> Printing file Id:" + Id);
		
		ProjectFile projectFile = userProjectService.getProjectFileById(Id);
		theModel.addAttribute("projectFile", projectFile);
		
		return "redirect:/userProfile/showUserProfile-userId-"+userDetailuserId;
	}
	
	@GetMapping("/deleteUserProject-userId-{userDetailuserId}-projectId-{userProjectprojectId}")
	public String deleteUserProject(@PathVariable int userDetailuserId, @PathVariable("userProjectprojectId") int projectId,
				Model theModel) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		userProjectService.delteUserProject(projectId);
		
		return "redirect:/userProfile/showUserProfile-userId-"+userDetailuserId;
	}
	
	@GetMapping("/updateUserProject-userId-{userDetailuserId}-projectId-{userProjectprojectId}")
	public String updateUserProject(@PathVariable int userDetailuserId, @PathVariable("userProjectprojectId") int projectId,
									Model theModel) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		UserProject theUserProject = userProjectService.getUserProjectById(projectId);
		theModel.addAttribute("userProject", theUserProject);
		
		return "project-form";
	}
	
	private void saveProjectFile (FileManager fileManager, UserProject theUserProject, ProjectFile theProjectFile) throws IOException{
		
		// se remueve crear project file
		//ProjectFile theProjectFile = new ProjectFile();
		
		MultipartFile multipartFile = fileManager.getFile();
	
		theProjectFile.setProjectFile(multipartFile.getBytes());
		
		theUserProject.setProjectFile(theProjectFile);
		
		userProjectService.saveProjectFile(theUserProject);
		
		
		
	}
	
	private void saveProjectDetail(UserProject theUserProject, UserDetail theUserDetail) throws IOException {
		
		theUserProject.setUserDetail(theUserDetail);
		
		userProjectService.saveProjectDetail(theUserProject);
		
	}
	
	
}	