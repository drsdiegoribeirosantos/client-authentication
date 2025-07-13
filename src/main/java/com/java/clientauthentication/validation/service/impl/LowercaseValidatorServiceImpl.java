package com.java.clientauthentication.validation.service.impl;

import org.springframework.stereotype.Service;

import com.java.clientauthentication.validation.service.ValidatorService;

@Service
public class LowercaseValidatorServiceImpl implements ValidatorService {

	@Override
	public boolean isValid(String password) {
		
		if (password == null) return false;
		
		for (int i = 0; i < password.length(); i++) {
			
	        if (Character.isLowerCase(password.charAt(i))) {
	            return true;
	        }
	        
	    }
		
	    return false;
	}
}
