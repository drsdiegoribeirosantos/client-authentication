package com.java.clientauthentication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.clientauthentication.service.PasswordValidationService;
import com.java.clientauthentication.service.ValidatorService;

@Service
public class PasswordValidationServiceImpl implements PasswordValidationService {

	@Autowired
	public List<ValidatorService> validatorService;

	@Override
	public boolean passwordValidation(String password) {

		for (ValidatorService validator : validatorService) {
			if (!validator.isValid(password)) {
				return false;
			}
		}
		return true;
	}

}
