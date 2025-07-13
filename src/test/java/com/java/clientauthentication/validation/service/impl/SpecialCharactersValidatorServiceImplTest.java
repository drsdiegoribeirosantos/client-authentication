package com.java.clientauthentication.validation.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpecialCharactersValidatorServiceImplTest {

    private SpecialCharactersValidatorServiceImpl validator;

    @BeforeEach
    void setUp() {
        validator = new SpecialCharactersValidatorServiceImpl();
    }

    @Test
    void shouldReturnTrue_WhenPasswordHasOneAllowedSpecialCharacter() {
        String password = "digital@";
        assertTrue(validator.isValid(password));
    }

    @Test
    void shouldReturnTrue_WhenPasswordHasMultipleDifferentAllowedSpecialCharacters() {
        String password = "!digital@";
        assertTrue(validator.isValid(password));
    }

    @Test
    void shouldReturnFalse_WhenPasswordHasRepeatedAllowedSpecialCharacter() {
        String password = "digital@@";
        assertFalse(validator.isValid(password));
    }

    @Test
    void shouldReturnFalse_WhenPasswordHasNoSpecialCharacters() {
        String password = "digital";
        assertFalse(validator.isValid(password));
    }

    @Test
    void shouldReturnFalse_WhenPasswordIsEmpty() {
        String password = "";
        assertFalse(validator.isValid(password));
    }

    @Test
    void shouldReturnFalse_WhenPasswordIsNull() {
    	String password = null;
        boolean result = validator.isValid(password);
        assertFalse(result);
    }
}