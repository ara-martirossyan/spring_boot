package com.aralmighty.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aralmighty.model.Status;
import com.aralmighty.service.StatusService;

@Controller
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	@RequestMapping(value="/status/delete/{id}", method=RequestMethod.GET)
	String deleteStatus(Model model, @PathVariable("id") Long id) {
		statusService.delete(id);		
		return "redirect:/statuses";
	}
	
	@RequestMapping(value="/status/edit/{id}", method=RequestMethod.GET)
	String editStatus(Model model, @PathVariable("id") Long id) {	
		Status status = statusService.findById(id);
		if (status != null) {
			model.addAttribute("status", status);
			return "app.editStatus";
		} 
		
		return "app.error";		
	}
	
	@RequestMapping(value="/status/edit/{id}", method=RequestMethod.POST)
	String editStatus(Model model, @Valid Status status,  BindingResult result) {	
		if (!result.hasErrors()) {
			statusService.save(status);
			return "redirect:/statuses";
		}
		
		return "app.editStatus";
	}
	
	@RequestMapping(value="/statuses", method=RequestMethod.GET)
	String viewStatus(Model model, @RequestParam(name="p", defaultValue="1") int pageNumber) {
		Page<Status> page = statusService.getPage(pageNumber);		
		model.addAttribute("page", page);
		return "app.viewStatus";
	}
	
	@RequestMapping(value="/add-status", method=RequestMethod.GET)
	String addStatus(Model model) {			
		
		model.addAttribute("status", new Status());
		
		Status latestStatus = statusService.getLatest();		
		model.addAttribute("latestStatus", latestStatus);
		
		return "app.addStatus";
	}
	
	@RequestMapping(value="/add-status", method=RequestMethod.POST)
	String addStatus(Model model, @Valid Status status,  BindingResult result) {
		
		if (!result.hasErrors()) {
			statusService.save(status);
			return "redirect:/statuses";
		}
		
		Status latestStatus = statusService.getLatest();		
		model.addAttribute("latestStatus", latestStatus);		
		
		return "app.addStatus";
	}
}
