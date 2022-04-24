package br.com.infogomes.analysisfinancial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.infogomes.analysisfinancial.entities.Importation;

@Repository
public interface ImportationRepository extends JpaRepository<Importation, Long> {
	List<Importation> findByOrderByDateTransactionDesc();
}
