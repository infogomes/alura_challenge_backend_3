package br.com.infogomes.analysisfinancial.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infogomes.analysisfinancial.entities.Transaction;
import br.com.infogomes.analysisfinancial.repositories.TransactionRepository;
import br.com.infogomes.analysisfinancial.services.TransactionService;
import br.com.infogomes.analysisfinancial.util.CSVUtil;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;

	public void save(List<String[]> transactions) {

		Transaction firstTransaction = CSVUtil.parseToTransaction(transactions.get(0));
		LocalDate data = firstTransaction.getTime().toLocalDate();
		List<Transaction> list = CSVUtil.parseToListTransaction(transactions);

		boolean listByData = existsByTimeBetween(LocalDateTime.of(data, LocalTime.of(0, 0)),
				LocalDateTime.of(data, LocalTime.MAX));
		System.out.println(listByData);
		
		if(listByData)
			throw new RuntimeException("Arquivo do dia já utilizado!");
		list.stream().filter(trans -> trans.getTime().toLocalDate().equals(data))
				.filter(trans -> !someFieldIsEmpty(trans)).forEach(t -> repository.save(t));

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
