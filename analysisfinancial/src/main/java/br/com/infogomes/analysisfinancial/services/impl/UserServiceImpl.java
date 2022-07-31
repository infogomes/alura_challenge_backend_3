package br.com.infogomes.analysisfinancial.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.infogomes.analysisfinancial.entities.User;
import br.com.infogomes.analysisfinancial.repositories.UserRepository;
import br.com.infogomes.analysisfinancial.services.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository repository; 

	@Override
	public User save(User user) {
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
