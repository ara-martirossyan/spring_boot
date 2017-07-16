package com.aralmighty.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aralmighty.model.SiteUser;
import com.aralmighty.model.VerificationToken;
import com.aralmighty.service.EmailService;
import com.aralmighty.service.UserService;

@Controller
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@Value("${message.registration.confirmed}")
	private String registrationConfirmedMessage;
	
	@Value("${message.expired.token}")
	private String expiredTokenMessage;
	
	@Value("${message.invalid.user}")
	private String invalidUserMessage;

	@RequestMapping("/login")
	String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "redirect:/";
		}
		
		return "app.login";
	}
	
	@RequestMapping("/verifyemail")
	String verifyEmail() {		
		return "app.verifyemail";
	}
	
	@RequestMapping("/confirmregister")
	String registrationConfirmed(Model model, @RequestParam("t") String tokenString) {
		VerificationToken token = userService.getVerificationToken(tokenString);
		
		if (token == null) {
			return "redirect:/invaliduser";
		}
		
		Date expiryDate =  token.getExpiry();
		
		if (expiryDate.before(new Date())) {
			userService.deleteToken(token);
			return "redirect:/expiredtoken";
		}
		
		SiteUser user = token.getUser();
		
		if (user == null) {
			userService.deleteToken(token);
			return "redirect:/invaliduser";
		}
		
		userService.deleteToken(token);
		user.setEnabled(true);
		userService.save(user);
		
		model.addAttribute("message", registrationConfirmedMessage);
		return "app.message";
	}
	
	@RequestMapping("/invaliduser")
	String invalideUser(Model model) {		
		model.addAttribute("message", invalidUserMessage);
		return "app.message";
	}
	
	@RequestMapping("/expiredtoken")
	String expiredToken(Model model) {		
		model.addAttribute("message", expiredTokenMessage);
		return "app.message";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	String register(Model model) {
		SiteUser user = new SiteUser();
		model.addAttribute("siteUser", user);
		return "app.register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	String register(Model model, @Valid SiteUser user, BindingResult result) {
		
		if (!result.hasErrors()) {
			userService.register(user);
			String token = userService.createEmailVerificationToken(user);
			
			emailService.sendVerificationEmail(user.getEmail(), token);
			return "redirect:/verifyemail";
		}
		
		return "app.register";
	}
	
}
