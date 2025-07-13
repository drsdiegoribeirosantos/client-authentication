package com.java.clientauthentication.validation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.clientauthentication.validation.service.ValidatorService;

@Service
public class SpecialCharactersValidatorServiceImpl implements ValidatorService {

	private static final List<String> ALLOWED_SPECIAL_CHARACTERS = List.of("!", "@", "#", "$", "%", "^", "&", "*", "(",
			")", "-", "+");

	@Override
	public boolean isValid(String password) {
		
		if (password == null) return false;

		List<String> repeatedCharacters = new ArrayList<>();

		boolean validCharacters = false;

		for (int i = 0; i < password.length(); i++) {

			String specialCharacter = String.valueOf(password.charAt(i));

			if (ALLOWED_SPECIAL_CHARACTERS.contains(specialCharacter)) {

				if (repeatedCharacters.contains(specialCharacter)) {
					return false;
				}

				repeatedCharacters.add(specialCharacter);

				validCharacters = true;
			}
		}

		return validCharacters;
	}

}
