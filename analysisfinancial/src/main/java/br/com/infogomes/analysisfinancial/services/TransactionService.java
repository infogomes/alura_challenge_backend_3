package br.com.infogomes.analysisfinancial.services;

import java.util.List;

public interface TransactionService {

	void save(List<String[]> parseToTransactionList);

}
