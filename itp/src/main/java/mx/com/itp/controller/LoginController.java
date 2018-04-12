package mx.com.itp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	// to be used after
	
	@GetMapping("/LoginPage")
	public String LoginPage() {
		
		return "demo-login";
	}
	
}
