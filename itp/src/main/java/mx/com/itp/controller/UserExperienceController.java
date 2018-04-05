package mx.com.itp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.itp.entity.UserDetail;
import mx.com.itp.entity.UserExperience;
import mx.com.itp.service.UserDetailService;
import mx.com.itp.service.UserExperienceService;

@Controller
@RequestMapping("/userExperience")
public class UserExperienceController {

	@Autowired
	private UserExperienceService userExperienceService;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@GetMapping("/listUserExperiences-userId-{userDetailuserId}")
	public String listUserExperience(@PathVariable int userDetailuserId ,Model theModel) {
		
		List<UserExperience> theUserExperiences = userExperienceService.getUserExperiences(userDetailuserId);
		theModel.addAttribute("userExperiences", theUserExperiences);
		
		//pendiente defnir return
		return "profile-page";
	}
	
	
	@GetMapping("/formForAddUserExperience-userId-{userDetailuserId}")
	public String formForAddUserExperience(@PathVariable("userDetailuserId") int Id, Model theModel) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(Id);
		theModel.addAttribute("userDetail", theUserDetail);
		
		UserExperience theUserExperience = new UserExperience();
		theModel.addAttribute("userExperience", theUserExperience);
		
		return "experience-form";
		
	}
	
	@PostMapping("/saveUserExperience-userId-{userDetailuserId}")
	public String saveUserExperience(@PathVariable int userDetailuserId , Model theModel , 
					@ModelAttribute("userExperience") UserExperience theUserExperience) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		saveUserExperience(theUserDetail, theUserExperience);
		
		return "redirect:/userProfile/showUserProfile-userId-"+userDetailuserId;
	}
	
	@GetMapping("/formForUpdateUserExperience-userId-{userDetailuserId}-experienceId-{userExperienceexperienceId}")
	public String formForUpdateUserExperience(@PathVariable int userDetailuserId, @PathVariable("userExperienceexperienceId") int experienceId, 
						Model theModel) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		UserExperience theUserExperience = userExperienceService.getUserExperience(experienceId);
		theModel.addAttribute("userExperience", theUserExperience);
		
		return "experience-form";
	}
	
	@GetMapping("/deleteUserExperience-userId-{userDetailuserId}-experienceId-{userExperienceexperienceId}")
	public String deleteUserExperience(@PathVariable int userDetailuserId,@PathVariable("userExperienceexperienceId")int Id, Model theModel) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		userExperienceService.deleteUserExperience(Id);
		
		return "redirect:/userProfile/showUserProfile-userId-"+userDetailuserId;
	}
	
	private void saveUserExperience(UserDetail theUserDetail, UserExperience theUserExperience) {
		
		theUserExperience.setUserDetail(theUserDetail);
		
		userExperienceService.saveUserExperience(theUserExperience);
		
	}
		
}
