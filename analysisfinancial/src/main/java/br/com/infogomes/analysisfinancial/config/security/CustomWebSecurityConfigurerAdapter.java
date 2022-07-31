package br.com.infogomes.analysisfinancial.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.infogomes.analysisfinancial.entities.User;
import br.com.infogomes.analysisfinancial.services.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserServiceImpl service;

	@Bean
	public User configUser() {
		return this.service.save(new User(null, "Admin", "admin@email.com.br", this.passwordEncoder.encode("123999")));

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/user/adduser").permitAll()
		.anyRequest().authenticated().and()
				.formLogin(form -> form.loginPage("/login").permitAll())
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login");
		// .loginPage("/login.html")
		// .loginProcessingUrl("/perform_login")
		// .defaultSuccessUrl("/homepage.html",true)
		// .failureUrl("/login.html?error=true")
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

}