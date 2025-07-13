package com.java.clientauthentication.validation.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UppercaseValidatorServiceImplTest {
	
	private UppercaseValidatorServiceImpl validator;

    @BeforeEach
    void setUp() {
        validator = new UppercaseValidatorServiceImpl();
    }

    @Test
    void shouldReturnTrue_WhenPasswordContainsUppercase() {
        String password = "Ldigital";
        boolean result = validator.isValid(password);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalse_WhenPasswordHasOnlyLowercaseAndDigits() {
        String password = "ldigital";
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
