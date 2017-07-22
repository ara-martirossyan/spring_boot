package com.aralmighty.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.owasp.html.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aralmighty.model.Profile;
import com.aralmighty.model.SiteUser;
import com.aralmighty.service.ProfileService;
import com.aralmighty.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PolicyFactory htmlPolicy;
	
	@Value("${photo.upload.directory}")
	private String photoUploadDirectory;
	
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

	@RequestMapping(value="/upload-profile-photo", method=RequestMethod.POST)
	String handlePhotoUploads(Model model, @RequestParam("file") MultipartFile file) {
		
		Path outputFilePath = Paths.get(photoUploadDirectory, file.getOriginalFilename());
		
		try {
			Files.deleteIfExists(outputFilePath);
			Files.copy(file.getInputStream(), outputFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/profile";
	}
}
