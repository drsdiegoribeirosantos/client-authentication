package com.java.clientauthentication.validation.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpecialCharactersValidatorServiceImplTest {

    private SpecialCharactersValidatorServiceImpl validator;

    @BeforeEach
    void setUp() {
        validator = new SpecialCharactersValidatorServiceImpl();
    }

    @Test
    void shouldReturnFalse_WhenPasswordIsNull() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void shouldReturnFalse_WhenPasswordDoesNotContainSpecialCharacters() {
        assertFalse(validator.isValid("digital"));
    }

    @Test
    void shouldReturnTrue_WhenPasswordContainsOneValidSpecialCharacter() {
        assertTrue(validator.isValid("digital11!"));
    }

    @Test
    void shouldReturnTrue_WhenPasswordContainsMultipleValidSpecialCharacters() {
        assertTrue(validator.isValid("digital@11#"));
    }

    @Test
    void shouldReturnTrue_WhenPasswordStartsWithSpecialCharacter() {
        assertTrue(validator.isValid("@digital"));
    }

    @Test
    void shouldReturnTrue_WhenPasswordEndsWithSpecialCharacter() {
        assertTrue(validator.isValid("digital2+"));
    }

    @Test
    void shouldReturnFalse_WhenPasswordContainsOnlyInvalidSpecialCharacters() {
        assertFalse(validator.isValid("digital10?<>~"));
    }

    @Test
    void shouldReturnTrue_WhenPasswordContainsValidAndInvalidSpecialCharacters() {
        assertTrue(validator.isValid("digital!<>"));
    }

    @Test
    void shouldReturnFalse_WhenPasswordIsEmpty() {
        assertFalse(validator.isValid(""));
    }

    @Test
    void shouldReturnTrue_WhenPasswordIsOnlyOneValidSpecialCharacter() {
        assertTrue(validator.isValid("@"));
    }

    @Test
    void shouldReturnFalse_WhenPasswordIsOnlyOneInvalidSpecialCharacter() {
        assertFalse(validator.isValid("="));
    }
}