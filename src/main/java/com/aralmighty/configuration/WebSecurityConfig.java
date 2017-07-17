package com.aralmighty.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.aralmighty.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.
	 * config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.authorizeRequests()
				.antMatchers(
						"/", "/about", 
						"/js/*", "/css/*", "/img/*", 
						"/invaliduser", "/expiredtoken",
						"/verifyemail", "/confirmregister"
				).permitAll()
				.antMatchers(
						"/status/delete/{\\d+}", 
						"/status/edit/{\\d+}", 
						"/add-status", 
						"/statuses"
				).hasRole("ADMIN")
				.antMatchers("/register").anonymous()
				.antMatchers("/profile").authenticated()
				.anyRequest()
				.denyAll()
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
			.logout()
				.permitAll();
		// @formatter:on
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}

}
