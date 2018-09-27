package com.iteahub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/itea-hub-login")
	public String showLoginPage()
	{
		return "itea-login";
	}
	@GetMapping("/itea-hub-managers-login")
	public String showManagerLoginPage()
	{
		return "itea-manager-login";
	}

}
