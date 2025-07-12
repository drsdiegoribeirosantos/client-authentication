package com.java.clientauthentication.validation.service.impl;

import org.springframework.stereotype.Service;

import com.java.clientauthentication.validation.service.ValidatorService;

@Service
public class CharacterSizeValidatorServiceImpl implements ValidatorService {

	@Override
	public boolean isValid(String password) {

	    if (password == null) return false;

	    String passwordClean = password.replaceAll("\\s", "");

	    return passwordClean.length() >= 9;
	}
}
