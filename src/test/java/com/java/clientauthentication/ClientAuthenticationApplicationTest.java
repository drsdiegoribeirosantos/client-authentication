package com.java.clientauthentication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientAuthenticationApplicationTest {

	 @Test
	    void shouldStartApplicationWithoutErrors() {
	        assertDoesNotThrow(() -> {
	            ClientAuthenticationApplication.main(new String[]{});
	        });
	    }

}
