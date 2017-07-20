package com.aralmighty.controllers;

import javax.validation.Valid;

import org.owasp.html.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@Autowired
	PolicyFactory htmlPolicy;
	
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
	
	@RequestMapping(value="/edit-profile-about", method=RequestMethod.GET)
	String editProfileAbout(Model model) {
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
		
		return "app.editProfileAbout";
	}
	
	@RequestMapping(value="/edit-profile-about", method=RequestMethod.POST)
	String editProfileAbout(Model model, @Valid Profile webProfile,  BindingResult result) {
		
		SiteUser user = getUser();
		Profile profile = profileService.getUserProfile(user);
		
		profile.safeMergeFrom(webProfile, htmlPolicy);
		
		if (!result.hasErrors()) {
			profileService.save(profile);
			return "redirect:/profile";
		}		
		
		return "app.editProfileAbout";
	}
}
