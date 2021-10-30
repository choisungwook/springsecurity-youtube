package com.demo.springseucurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class SpringseucurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringseucurityApplication.class, args);
	}

	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
				.username("user")
				.password("{noop}password")
				.roles("USER")
				.build();

		UserDetails admin = User.builder()
				.username("admin")
				.password("{noop}password")
				.roles("USER", "ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user, admin);
	}

}
