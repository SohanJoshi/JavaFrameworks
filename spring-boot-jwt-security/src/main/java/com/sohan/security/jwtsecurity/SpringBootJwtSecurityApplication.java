package com.sohan.security.jwtsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The exception here is not working. Not sure why. The exception message is not being sent in response.
 * The first request /token sends back the token, using the secret key and the JWTUser details int eh POST request.
 * The same token when sent back in any request to /rest/** authorizes the request.
 */
@SpringBootApplication
public class SpringBootJwtSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtSecurityApplication.class, args);
	}

}
