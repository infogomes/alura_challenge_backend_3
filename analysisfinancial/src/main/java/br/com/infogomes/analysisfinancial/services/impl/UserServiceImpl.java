package br.com.infogomes.analysisfinancial.services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infogomes.analysisfinancial.entities.User;
import br.com.infogomes.analysisfinancial.repositories.UserRepository;
import br.com.infogomes.analysisfinancial.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User save(User user) {
		Random rnd = new Random();
		String password = String.valueOf(rnd.nextInt(999999));
		user.setPassword(password);
		return repository.save(user);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

}
