package br.com.infogomes.analysisfinancial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.infogomes.analysisfinancial.services.EmailService;
import br.com.infogomes.analysisfinancial.services.impl.EmailServiceImpl;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	public EmailService emailService() {
		return new EmailServiceImpl();
	}

}
