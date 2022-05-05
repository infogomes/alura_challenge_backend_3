package br.com.infogomes.analysisfinancial.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.infogomes.analysisfinancial.entities.User;
import br.com.infogomes.analysisfinancial.repositories.UserRepository;
import br.com.infogomes.analysisfinancial.services.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 

	@Override
	public User save(User user) {
		if(Optional.ofNullable(user.getPassword()).isEmpty()) {
			Random rnd = new Random();
			String password = String.valueOf(rnd.nextInt(999999));
			user.setPassword(passwordEncoder.encode(password));
		}
		return repository.save(user);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByEmail(username);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("User not found.");
		}

		UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
		builder.password(user.get().getPassword());
		builder.roles("");
		return builder.build();
	}

}
