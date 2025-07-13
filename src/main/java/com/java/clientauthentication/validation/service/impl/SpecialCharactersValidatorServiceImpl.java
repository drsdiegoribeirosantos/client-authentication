package com.java.clientauthentication.validation.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.java.clientauthentication.validation.service.ValidatorService;

@Service
public class SpecialCharactersValidatorServiceImpl implements ValidatorService {

	private static final Set<Character> ALLOWED_SPECIAL_CHARACTERS = Set.of(
	        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'
	    );

	@Override
	public boolean isValid(String password) {
		
		if (password == null) return false;

		for (char c : password.toCharArray()) {
            if (ALLOWED_SPECIAL_CHARACTERS.contains(c)) {
                return true;
            }
        }

        return false;
    }

}
