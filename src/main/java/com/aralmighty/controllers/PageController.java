package com.aralmighty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aralmighty.model.Status;
import com.aralmighty.service.StatusService;


@Controller
public class PageController {
	
	@Autowired
	private StatusService statusService;
	
	@Value("${message.error.forbidden}")
	private String accessDeniedMessage;
	
	@Value("${message.error.bad.request}")
	private String bedRequestMessage;
	
	@RequestMapping("/")
	String home(Model model) {
		Status latestStatus = statusService.getLatest();		
		model.addAttribute("latestStatus", latestStatus);	
		return "app.homepage";
	}

	@RequestMapping("/about")
	String about() {
		return "app.about";
	}
	
	@RequestMapping("/403")
	String accessDenied(Model model) {		
		model.addAttribute("message", accessDeniedMessage);
		return "app.message";
	}
	
	@RequestMapping("/400")
	String badRequestError(Model model) {		
		model.addAttribute("message", bedRequestMessage);
		return "app.message";
	}
}
