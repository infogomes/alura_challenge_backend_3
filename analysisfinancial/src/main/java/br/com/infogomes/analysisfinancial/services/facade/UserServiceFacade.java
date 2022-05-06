package br.com.infogomes.analysisfinancial.services.facade;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.infogomes.analysisfinancial.entities.User;
import br.com.infogomes.analysisfinancial.services.EmailService;
import br.com.infogomes.analysisfinancial.services.UserService;

@Service
public class UserServiceFacade {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private EmailService emailService;
	
	//TODO Verify if is necessary put in a transaction
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User user) {
		
		if(Optional.ofNullable(user.getPassword()).isEmpty()) {
			Random rnd = new Random();
			user.setPassword(String.valueOf(rnd.nextInt(999999)));
		}
		
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		User savedUser = service.save(user);

		emailService.send(user.getEmail(), "E-mail cadastro", password);
		
		return savedUser; 
	}

}
