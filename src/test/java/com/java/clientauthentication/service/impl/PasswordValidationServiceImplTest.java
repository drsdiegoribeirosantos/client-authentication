package com.java.clientauthentication.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.java.clientauthentication.validation.service.impl.CharacterSizeValidatorServiceImpl;
import com.java.clientauthentication.validation.service.impl.LowercaseValidatorServiceImpl;
import com.java.clientauthentication.validation.service.impl.NumericDigitValidatorServiceImpl;
import com.java.clientauthentication.validation.service.impl.RepeatedCharacterValidatorServiceImpl;
import com.java.clientauthentication.validation.service.impl.SpecialCharactersValidatorServiceImpl;
import com.java.clientauthentication.validation.service.impl.UppercaseValidatorServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidationServiceImplTest {

    private PasswordValidationServiceImpl passwordValidationService;

    @BeforeEach
    void setUp() {
        passwordValidationService = new PasswordValidationServiceImpl();
        
        passwordValidationService.validatorService = List.of(
            new CharacterSizeValidatorServiceImpl(),
            new NumericDigitValidatorServiceImpl(),
            new LowercaseValidatorServiceImpl(),
            new UppercaseValidatorServiceImpl(),
            new SpecialCharactersValidatorServiceImpl(),
            new RepeatedCharacterValidatorServiceImpl()
        );
    }

    @Test
    void shouldReturnTrue_WhenPasswordIsFullyValid() {
        String password = "L10digtal@";
        assertTrue(passwordValidationService.passwordValidation(password));
    }

    @Test
    void shouldReturnFalse_WhenPasswordIsTooShort() {
        String password = "Ldi@";
        assertFalse(passwordValidationService.passwordValidation(password));
    }

    @Test
    void shouldReturnFalse_WhenMissingUppercase() {
        String password = "digtal@2";
        assertFalse(passwordValidationService.passwordValidation(password));
    }

    @Test
    void shouldReturnFalse_WhenMissingLowercase() {
        String password = "DIGTAL@2";
        assertFalse(passwordValidationService.passwordValidation(password));
    }

    @Test
    void shouldReturnFalse_WhenMissingDigit() {
        String password = "Ldigtal@#";
        assertFalse(passwordValidationService.passwordValidation(password));
    }

    @Test
    void shouldReturnFalse_WhenMissingSpecialCharacter() {
        String password = "Ldigtal2"; 
        assertFalse(passwordValidationService.passwordValidation(password));
    }

    @Test
    void shouldReturnFalse_WhenHasRepeatedCharacters() {
        String password = "L11digtal@";
        assertFalse(passwordValidationService.passwordValidation(password));
    }
}