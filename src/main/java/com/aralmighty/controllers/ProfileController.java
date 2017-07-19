package com.aralmighty.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aralmighty.model.Profile;

@Controller
public class ProfileController {	
	@RequestMapping("/profile")
	String showProfile(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Profile profile = new Profile();
		String username = auth.getName();
		model.addAttribute("username", username);
		model.addAttribute("profile", profile);
		return "app.profile";
	}
}
