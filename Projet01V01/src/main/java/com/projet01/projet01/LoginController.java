package com.projet01.projet01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value="/Login")
	public String Seconnecter(){
		return "Login";
	}
}
