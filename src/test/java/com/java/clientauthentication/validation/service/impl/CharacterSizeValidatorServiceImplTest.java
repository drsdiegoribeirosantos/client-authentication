package com.java.clientauthentication.validation.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterSizeValidatorServiceImplTest {

	private CharacterSizeValidatorServiceImpl validator;

    @BeforeEach
    void setup() {
        validator = new CharacterSizeValidatorServiceImpl();
    }

    @Test
    void shouldReturnFalse_WhenPasswordIsNull() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void shouldReturnFalse_WhenPasswordHasLessThanNineCharacters() {
        assertFalse(validator.isValid("l11dig"));
    }

    @Test
    void shouldReturnTrue_WhenPasswordHasExactlyNineCharacters() {
        assertTrue(validator.isValid("L11digita"));
    }

    @Test
    void shouldReturnTrue_WhenPasswordHasMoreThanNineCharacters() {
        assertTrue(validator.isValid("L11digital!"));
    }

    @Test
    void shouldIgnoreSpaces_WhenValidatingCharacterCount() {
        assertTrue(validator.isValid("L 11 digi ta"));
    }

    @Test
    void shouldReturnFalse_WhenOnlySpaces() {
        assertFalse(validator.isValid("         "));
    }

    @Test
    void shouldReturnFalse_WhenEmptyString() {
        assertFalse(validator.isValid(""));
    }
}
