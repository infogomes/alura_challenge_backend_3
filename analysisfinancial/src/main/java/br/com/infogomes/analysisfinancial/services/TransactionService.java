package br.com.infogomes.analysisfinancial.services;

import java.util.List;

import br.com.infogomes.analysisfinancial.entities.Transaction;

public interface TransactionService {

	List<Transaction> save(List<Transaction> parseToTransactionList);

}
