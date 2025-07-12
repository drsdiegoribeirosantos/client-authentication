package com.java.clientauthentication.validation.service.impl;

import org.springframework.stereotype.Service;

import com.java.clientauthentication.validation.service.ValidatorService;

@Service
public class UppercaseValidatorServiceImpl implements ValidatorService {

	@Override
	public boolean isValid(String password) {
		
		for (int i = 0; i < password.length(); i++) {
			
	        if (Character.isUpperCase(password.charAt(i))) {
	            return true;
	        }
	        
	    }
		
	    return false;
	}
	
}
