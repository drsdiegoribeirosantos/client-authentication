package com.java.clientauthentication.validation.service.impl;


import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.java.clientauthentication.validation.service.ValidatorService;

@Service
public class RepeatedCharacterValidatorServiceImpl implements ValidatorService {

	@Override
	public boolean isValid(String password) {
		
		if (password == null) return false;

		HashSet<Character> exists = new HashSet<>();

        for (char c : password.toCharArray()) {
            if (exists.contains(c)) {
                return false; 
            }
            exists.add(c);
        }

        return true; 
    }

}
