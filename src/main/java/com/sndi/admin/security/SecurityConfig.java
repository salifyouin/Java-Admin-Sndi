package com.sndi.admin.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	/*	auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN","USER");
		auth.inMemoryAuthentication().withUser("user").password("1234").roles("USER");
	}
			*/
		 
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username as principal, password as credentials, true from users where username=?")
		.authoritiesByUsernameQuery("select user_username as principal,roles_role as role from users_roles where user_username=?")
		.rolePrefix("ROLE_");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");	
		//http.authorizeRequests().antMatchers("/css/**","/js/**","/images/**").permitAll();
		http.authorizeRequests().antMatchers("/operations","/consultercompte").hasRole("USER");
		http.authorizeRequests().antMatchers("/saveOperation","/operations").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
		http.logout()
		   .invalidateHttpSession(true)
		       .logoutUrl("/logout")
		       .permitAll();
		}
	    

}
