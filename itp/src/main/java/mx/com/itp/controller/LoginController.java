package mx.com.itp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Login")
public class LoginController {

	@GetMapping("/LoginPage")
	public String LoginPage() {
		
		return "demo-login";
	}
	
}
