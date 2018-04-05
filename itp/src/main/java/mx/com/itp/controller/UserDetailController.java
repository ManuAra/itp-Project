package mx.com.itp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	
	@GetMapping("/listUserDetails")
	public String listuserDetails(Model theModel) {
		
		List<UserDetail> theUserDetails = userDetailService.getUserDetails();
		
		theModel.addAttribute("usersDetails", theUserDetails);
		
		//provisional
		
		return "home-page";
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
		
		return "redirect:/userDetail/listUserDetails";
	}
	
	@GetMapping("/formForUpdateUserDetail")
	public String formForUpdateUserDetail(@RequestParam("userId") int theId, Model theModel) {
		
		UserDetail theUserDetail = userDetailService.getUserDetail(theId);
		
		theModel.addAttribute("userDetail", theUserDetail);
		
		return "userDetail-form";
	}
	
	@GetMapping("/deleteUserDetail")
	public String deleteUserDetail(@RequestParam("userDetail") int theId) {
		
		userDetailService.deleteUserDetail(theId);
		
		return "redirect";
	}
}

