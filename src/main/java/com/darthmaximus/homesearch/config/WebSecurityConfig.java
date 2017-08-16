package com.darthmaximus.homesearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		web
			.ignoring()
				.antMatchers("/web/homes**")
				.antMatchers("/web/homes/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/web**").permitAll()
				.antMatchers("/web/customers**").access("hasRole('ADMIN')")
				.antMatchers("/web/admin**").access("hasRole('ADMIN')")
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/web")
				.failureUrl("/login?m=login")
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?m=logout")
				.permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/accessDenied");
		http.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
			.sessionFixation().migrateSession()
			.maximumSessions(10)
			.expiredUrl("/login?m=expired");
	}
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("maximus").password("maximus").roles("ADMIN");
	}
}
