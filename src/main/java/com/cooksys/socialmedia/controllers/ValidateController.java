package com.cooksys.socialmedia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.services.ValidateService;

@RestController
@RequestMapping(path = "/validate")
public class ValidateController {

	private ValidateService validateService;

	public ValidateController(ValidateService validateService) {
		super();
		this.validateService = validateService;
	}

	@GetMapping("/tag/exists/{label}")
	public boolean validateTag(String label) {
		return validateService.validateTag(label);
	}

	@GetMapping("/username/available/@{username}")
	public boolean usernameAvailable(String username) {
		return validateService.usernameAvailable(username);
	}
}
