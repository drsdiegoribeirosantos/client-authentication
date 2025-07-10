package com.java.clientauthentication.service.impl;

import org.springframework.stereotype.Service;

import com.java.clientauthentication.service.ValidatorService;

@Service
public class ValidatesUppercaseServiceImpl implements ValidatorService {

	@Override
	public boolean isValid(String password) {
		return false;
	}
}
