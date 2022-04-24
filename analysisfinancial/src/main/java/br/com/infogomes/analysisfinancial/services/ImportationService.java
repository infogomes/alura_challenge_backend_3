package br.com.infogomes.analysisfinancial.services;

import java.util.List;

import br.com.infogomes.analysisfinancial.entities.Importation;

public interface ImportationService {

	Importation save(Importation importation);

	List<Importation> findAll();
	
	List<Importation> findByOrderByDateTransactionDesc();

}
