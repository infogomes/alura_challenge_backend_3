package br.com.infogomes.analysisfinancial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.infogomes.analysisfinancial.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
