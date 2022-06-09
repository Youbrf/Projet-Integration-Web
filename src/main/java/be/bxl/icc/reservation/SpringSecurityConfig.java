package be.bxl.icc.reservation;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import be.bxl.icc.reservation.model.CustomUserDetailsService;

@Configuration
@EnableWebSecurity

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		
		return new CustomUserDetailsService();
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public  DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.antMatchers("/").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.usernameParameter("email")
		.defaultSuccessUrl("/login")
		.permitAll() 
		.and()
        .logout().logoutSuccessUrl("/").permitAll();	
		
		
		
	}
	
	
	
	
	
	

	/*
	 * @Override public void configure(HttpSecurity http) throws Exception {
	 * 
	 * http
	 * 
	 * .authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers(
	 * "/user").hasRole("USER") .anyRequest().authenticated().and().formLogin(); }
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("springuser").password(passwordEncoder
	 * ().encode("spring123"))
	 * .roles("USER").and().withUser("springadmin").password(passwordEncoder().
	 * encode("admin123")) .roles("ADMIN", "USER"); }
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
}