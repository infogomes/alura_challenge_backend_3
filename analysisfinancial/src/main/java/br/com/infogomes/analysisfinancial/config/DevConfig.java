package br.com.infogomes.analysisfinancial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.infogomes.analysisfinancial.services.EmailService;
import br.com.infogomes.analysisfinancial.services.impl.EmailServiceMockImpl;

@Configuration
@Profile("dev")
public class DevConfig {

	@Bean
	public EmailService emailService() {
		return new EmailServiceMockImpl();
	}
	
}
