package com.jwt.auth;

import com.jwt.auth.service.TokenGeneratorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJwtAuthenticationApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringBootJwtAuthenticationApplication.class, args);

		TokenGeneratorService service = ctx.getBean("TokenGenerator",TokenGeneratorService.class);

		String token = service.generateToken();

		System.out.println("Generated Token: " + token);

		service.readToken(token);

	}

}
