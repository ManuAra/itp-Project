package mx.com.itp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.com.itp.entity.UserDetail;
import mx.com.itp.entity.UserExperience;
import mx.com.itp.entity.UserProject;
import mx.com.itp.entity.UserSkill;
import mx.com.itp.service.UserDetailService;
import mx.com.itp.service.UserExperienceService;
import mx.com.itp.service.UserProjectService;
import mx.com.itp.service.UserSkillService;

@Controller
@RequestMapping("/userProfile")
public class UserProfileController {

	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired 
	private UserExperienceService userExperienceService;
	
	@Autowired
	private UserProjectService userProjectService;
	
	@Autowired
	private UserSkillService userSkillService;
	
	
	@GetMapping("/showSkillForm")
	//  provisional method to skill form
	public String goToSKillForm() {
		
		return "skill-form";
	}
	
	@GetMapping("/projectForm")
	public String projectForm() {
		
		return "project-form";
	}
	
	@GetMapping("/experienceForm")
	public String experienceForm() {
		
		return "experience-form";
	}
	
	//metodo para home page(provisional recordar quitarlo)
	
	@GetMapping("/showLoginPage")
	public String showLoginPage(Model theModel) {
		
		List<UserDetail> theUserDetails = userDetailService.getUserDetails();
		
		theModel.addAttribute("usersDetails", theUserDetails);
		
		return "home-page";
	}
	
	@GetMapping("/showHomePage")
	public String showHomePage(Model theModel) {
		
		List<UserDetail> theUserDetails = userDetailService.getUserDetails();
		
		theModel.addAttribute("usersDetails", theUserDetails);
		
		return "home-page";
	}
	
	@PostMapping("/search")
	public String searchUser(@RequestParam("SearchName") String SearchName, Model theModel) {
		
		List<UserDetail> theUserDetails = userDetailService.searchUser(SearchName);
		
		theModel.addAttribute("usersDetails", theUserDetails);
		
		return "home-page";
	}
	
	@GetMapping("/showUserProfile-userId-{userDetailuserId}")
	public String showUserProfile(@PathVariable int userDetailuserId , Model theModel) {
		
			UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
			theModel.addAttribute("userDetail", theUserDetail);
			
			//List of experiences by user Id
			
			List<UserExperience> theUserExperiences = userExperienceService.getUserExperiences(userDetailuserId);
			theModel.addAttribute("userExperiences", theUserExperiences);
			
			// List of projects by user Id
			
			List<UserProject> theProjects = userProjectService.getAllProjectsById(userDetailuserId);
			theModel.addAttribute("userProjects", theProjects);
			
			// List of skills by user Id
			
			List<UserSkill> theUserSkills = userSkillService.getUserSkillsById(userDetailuserId);
			theModel.addAttribute("userSkills" ,theUserSkills);
			
		return "profile-page";
		
	}
	
	// project form
	
	@GetMapping("showProjectForm")
	public String showProjectForm() {
		
		
		return "project-form";
	}
	//userDetailController/showFormForUpdateUserDetail
	@GetMapping("/getUserDetail")
	public String getUserDetail(@RequestParam("userId") int theId, Model theModel) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(theId);
		
		theModel.addAttribute("userDetail", theUserDetail);
		
		return "redirect:/userProfile/showUserProfile";
	}
}
