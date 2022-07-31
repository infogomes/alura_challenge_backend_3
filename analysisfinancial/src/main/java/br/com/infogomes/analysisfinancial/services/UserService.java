package br.com.infogomes.analysisfinancial.services;

import java.util.List;

import br.com.infogomes.analysisfinancial.entities.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

}
