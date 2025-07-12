package com.java.clientauthentication.validation.service.impl;

import org.springframework.stereotype.Service;

import com.java.clientauthentication.validation.service.ValidatorService;

@Service
public class NumericDigitValidatorServiceImpl implements ValidatorService {

	@Override
	public boolean isValid(String password) {
		
		if (password == null) return false;
		
	    return password.matches(".*\\d.*");
	}
}
