package com.aralmighty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aralmighty.model.Profile;
import com.aralmighty.model.SiteUser;
import com.aralmighty.service.ProfileService;
import com.aralmighty.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	UserService userService;
	
	private SiteUser getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		SiteUser user = userService.get(email);
		
		return user;
	}
	
	@RequestMapping("/profile")
	String showProfile(Model model) {
		SiteUser user = getUser();
		Profile profile = profileService.getUserProfile(user);
		
		if (profile == null) {
			profile = new Profile();
			profile.setUser(user);
			profileService.save(profile);
		}
		
		Profile webProfile = new Profile();
		webProfile.safeCopyFrom(profile);
		
		model.addAttribute("profile", webProfile);
		return "app.profile";
	}
}
