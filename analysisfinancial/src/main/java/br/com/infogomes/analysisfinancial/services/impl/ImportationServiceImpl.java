package br.com.infogomes.analysisfinancial.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infogomes.analysisfinancial.entities.Importation;
import br.com.infogomes.analysisfinancial.repositories.ImportationRepository;
import br.com.infogomes.analysisfinancial.services.ImportationService;

@Service
public class ImportationServiceImpl implements ImportationService{

	@Autowired
	private ImportationRepository repository;
	
	@Override
	public Importation save(Importation importation) {
		return repository.save(importation);
	}

	@Override
	public List<Importation> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Importation> findByOrderByDateTransactionDesc() {
		return repository.findByOrderByDateTransactionDesc();
	}
	
	
	
}
