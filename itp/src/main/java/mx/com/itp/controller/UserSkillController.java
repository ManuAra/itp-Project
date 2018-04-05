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
import mx.com.itp.entity.UserSkill;
import mx.com.itp.service.UserDetailService;
import mx.com.itp.service.UserSkillService;

@Controller
@RequestMapping("/userSkill")
public class UserSkillController {

	@Autowired
	private UserSkillService userSkillService;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@GetMapping("/listUserSkills-userId-{userDetailuserId}")
	public String listUserSkills(@PathVariable int userDetailuserId , Model theModel) {
		
		List<UserSkill> theUserSkills = userSkillService.getUserSkillsById(userDetailuserId);
		theModel.addAttribute("userSkills" ,theUserSkills);
 		
		//Primarily this method will be used in the user profile controller, so the return isnt needed 
		return "";
	}
	
	@GetMapping("/formForAddUserSkill-{userDetailuserId}")
	public String formForAddUserSkill(@PathVariable int userDetailuserId, Model theModel) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		UserSkill theUserSkill = new UserSkill();
		theModel.addAttribute("userSkill", theUserSkill);
			
		return "skill-form";
	}
	
	@PostMapping("/saveUserSkill-userId-{userDetailuserId}")
	public String saveUserSkill(@PathVariable int userDetailuserId , Model theModel,
								UserSkill theUserSkill )  {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		saveUserSkill(theUserDetail, theUserSkill);
		
		return "redirect:/userProfile/showUserProfile-userId-"+userDetailuserId;
	}
		
	@GetMapping("/deleteSkill-userId-{userDetailuserId}-skillId-{userSkillskillId}")
	public String deleteSkill(@PathVariable int userDetailuserId,@PathVariable("userSkillskillId") int skillId,
						Model theModel) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userDetailuserId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		userSkillService.deleteSkill(skillId);
		
		return "redirect:/userProfile/showUserProfile-userId-"+userDetailuserId;
		
	}
	
	private void saveUserSkill (UserDetail theUserDetail, UserSkill theUserSkill) {
		
		theUserSkill.setUserDetail(theUserDetail);
		
		userSkillService.saveUserSkill(theUserSkill);
	}
	
}
