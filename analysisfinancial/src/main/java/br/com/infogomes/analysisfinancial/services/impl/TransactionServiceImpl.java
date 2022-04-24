package br.com.infogomes.analysisfinancial.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infogomes.analysisfinancial.entities.Transaction;
import br.com.infogomes.analysisfinancial.repositories.TransactionRepository;
import br.com.infogomes.analysisfinancial.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;

	public List<Transaction> save(List<Transaction> transactions) {

		if (transactions.size() <= 0)
			throw new RuntimeException("O arquivo está vazio!");

		LocalDate transactionDate = transactions.get(0).getTime().toLocalDate();

		if (existsByTimeBetween(transactionDate))
			throw new RuntimeException("Arquivo do dia já utilizado!");

		transactions = transactions.stream().filter(trans -> trans.getTime().toLocalDate().equals(transactionDate))
				.filter(trans -> !someFieldIsEmpty(trans)).collect(Collectors.toList());

		return repository.saveAll(transactions);

	}

	private boolean existsByTimeBetween(LocalDate data) {
		return existsByTimeBetween(LocalDateTime.of(data, LocalTime.of(0, 0)), LocalDateTime.of(data, LocalTime.MAX));
	}

	boolean existsByTimeBetween(LocalDateTime startDate, LocalDateTime endDate) {
		return repository.existsByTimeBetween(startDate, endDate);
	}

	private boolean someFieldIsEmpty(Transaction transaction) {
		return transaction.getSourceBank().isBlank() || transaction.getSourceAgency().isBlank()
				|| transaction.getSourceAccount().isBlank() || transaction.getDestinationBank().isBlank()
				|| transaction.getDestinationAgency().isBlank() || transaction.getDestinationAccount().isBlank()
				|| transaction.getTime() == null || transaction.getValue() == null;
	}

}
