package com.java.clientauthentication.validation.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumericDigitValidatorServiceImplTest {

    private NumericDigitValidatorServiceImpl validator;

    @BeforeEach
    public void setup() {
        validator = new NumericDigitValidatorServiceImpl();
    }
    
    @Test
    public void shouldReturnFalse_whenPasswordHasNoDigits() {
        assertFalse(validator.isValid("digital"));
    }

    @Test
    public void shouldReturnTrue_whenPasswordContainsDigits() {
        assertTrue(validator.isValid("digital10"));
    }

    @Test
    public void shouldReturnTrue_whenPasswordIsOnlyDigits() {
        assertTrue(validator.isValid("240299"));
    }

    @Test
    public void shouldReturnTrue_whenPasswordHasDigitsAndSpecialChars() {
        assertTrue(validator.isValid("@2!"));
    }
    
    @Test
    public void shouldReturnFalse_whenPasswordIsEmpty() {
        assertFalse(validator.isValid(""));
    }
    
    @Test
    void shouldReturnFalse_WhenPasswordIsNull() {
    	String password = null;
        boolean result = validator.isValid(password);
        assertFalse(result);
    }
}