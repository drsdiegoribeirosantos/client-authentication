package com.java.clientauthentication.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.java.clientauthentication.service.PasswordValidationService;

public class AuthenticationControllerTest {

    private AuthenticationController controller;
    private PasswordValidationService passwordValidationService;

    @BeforeEach
    void setUp() {
        passwordValidationService = mock(PasswordValidationService.class);
        
        controller = new AuthenticationController();
        
        controller.passwordValidationService = passwordValidationService;
    }

    @Test
    void shouldReturnTrue_WhenServiceReturnsTrue() {
        String password = "L24digtal@";

        when(passwordValidationService.passwordValidation(password)).thenReturn(true);

        boolean result = controller.passwordValidation(password);

        assertTrue(result);
        verify(passwordValidationService).passwordValidation(password);
    }

    @Test
    void shouldReturnFalse_WhenServiceReturnsFalse() {
        String password = "dig";

        when(passwordValidationService.passwordValidation(password)).thenReturn(false);

        boolean result = controller.passwordValidation(password);

        assertFalse(result);
        verify(passwordValidationService).passwordValidation(password);
    }
}