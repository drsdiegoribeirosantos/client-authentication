package com.java.clientauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.clientauthentication.service.PasswordValidationService;

@RestController
public class AuthenticationController {
	
	@Autowired
	public PasswordValidationService passwordValidationService;
	
	@GetMapping("/password-validation")
	public boolean passwordValidation(@RequestParam String password) {
		return passwordValidationService.passwordValidation(password);
	}
	

}
