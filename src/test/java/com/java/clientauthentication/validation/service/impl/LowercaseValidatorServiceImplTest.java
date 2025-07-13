package com.java.clientauthentication.validation.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LowercaseValidatorServiceImplTest {

	private LowercaseValidatorServiceImpl validator;

    @BeforeEach
    void setUp() {
        validator = new LowercaseValidatorServiceImpl();
    }

    @Test
    void shouldReturnTrue_WhenPasswordContainsUppercase() {
        String password = "LDIGITaL";
        boolean result = validator.isValid(password);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalse_WhenPasswordHasOnlyLowercaseAndDigits() {
        String password = "LDIGITAL";
        boolean result = validator.isValid(password);
        assertFalse(result);
    }

    @Test
    void shouldReturnFalse_WhenPasswordIsEmpty() {
        String password = "";
        boolean result = validator.isValid(password);
        assertFalse(result);
    }
    
    @Test
    void shouldReturnFalse_WhenPasswordIsNull() {
    	String password = null;
        boolean result = validator.isValid(password);
        assertFalse(result);
    }
    
}
