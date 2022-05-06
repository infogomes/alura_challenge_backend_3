package br.com.infogomes.analysisfinancial.services.impl;

import br.com.infogomes.analysisfinancial.services.EmailService;

public class EmailServiceMockImpl implements EmailService {

	public void send(String to, String subject, String text) {
		System.out.println("Sua senha é " + text);
	}
}
