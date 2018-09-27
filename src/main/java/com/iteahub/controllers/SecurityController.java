package com.iteahub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	@GetMapping("/itea-access-denied")
	public String showiTeaAccessDeniedPage()
	{
		return "itea-access-denied";
	}

}
