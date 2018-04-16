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
import org.springframework.web.bind.annotation.RequestParam;

import mx.com.itp.entity.UserDetail;
import mx.com.itp.service.UserDetailService;

@Controller
@RequestMapping("/userDetail")
public class UserDetailController {

	@Autowired
	private UserDetailService userDetailService;
	
	// This method its used on another controller, thus the void
	@GetMapping("/listUserDetails")
	public void listuserDetails(Model theModel) {
		
		List<UserDetail> theUserDetails = userDetailService.getUserDetails();
		
		theModel.addAttribute("usersDetails", theUserDetails);
		
	}
	
	@GetMapping("/formForAddUserDetail")
	public String formForAddUserDetail(Model theModel) {
		
		UserDetail theUserDetail = new UserDetail();
		
		theModel.addAttribute("userDetail", theUserDetail);
		
		return "userDetail-form";
	}
	
	@PostMapping("/saveUserDetail")
	public String saveUserDetail(@ModelAttribute("userDetail") UserDetail theUserDetail) {
		
		userDetailService.saveUserDetail(theUserDetail);
		
		return "redirect:/userProfile/showHomePage";
	}
	
	@GetMapping("/formForUpdateUserDetail-userId-{userDetailuserId}")
	public String formForUpdateUserDetail(@PathVariable("userDetailuserId") int userId, Model theModel) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(userId);
		theModel.addAttribute("userDetail", theUserDetail);
		
		return "userDetail-form";
	}
	
	@GetMapping("/deleteUserDetail-userId-{userDetailuserId}")
	public String deleteUserDetail(@PathVariable("userDetailuserId") int userId) {
		
		userDetailService.deleteUserDetail(userId);
		
		return "redirect:/userProfile/showHomePage";
	}
}

