package com.java.clientauthentication.validation.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepeatedCharacterValidatorServiceImplTest {

    private RepeatedCharacterValidatorServiceImpl validator;

    @BeforeEach
    void setUp() {
        validator = new RepeatedCharacterValidatorServiceImpl();
    }

    @Test
    void shouldReturnFalse_WhenPasswordIsNull() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void shouldReturnTrue_WhenAllCharactersAreUnique() {
        assertTrue(validator.isValid("Ldigt@"));
    }

    @Test
    void shouldReturnFalse_WhenThereAreRepeatedLowerCaseCharacters() {
        assertFalse(validator.isValid("AaaBbCcc"));
    }

    @Test
    void shouldReturnFalse_WhenThereAreRepeatedUpperCaseCharacters() {
        assertFalse(validator.isValid("LdigL"));
    }

    @Test
    void shouldReturnTrue_WhenCharactersAreCaseSensitive() {
        assertTrue(validator.isValid("Ll"));
    }

    @Test
    void shouldReturnTrue_WhenPasswordIsEmpty() {
        assertTrue(validator.isValid(""));
    }

    @Test
    void shouldReturnTrue_WhenPasswordIsSingleCharacter() {
        assertTrue(validator.isValid("d"));
    }

    @Test
    void shouldReturnFalse_WhenRepeatedDigits() {
        assertFalse(validator.isValid("1011"));
    }

    @Test
    void shouldReturnTrue_WhenSpecialCharactersAreUnique() {
        assertTrue(validator.isValid("!@+"));
    }

    @Test
    void shouldReturnFalse_WhenSpecialCharactersAreRepeated() {
        assertFalse(validator.isValid("dig@@"));
    }
}