package com.fpt.namhnp_assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.fpt.namhnp_assignment1.config.JWTAuthorizationFilter;

@ComponentScan("com.fpt.namhnp_assignment1")
@SpringBootApplication(scanBasePackages = "com.fpt.namhnp_assignment1")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
}
