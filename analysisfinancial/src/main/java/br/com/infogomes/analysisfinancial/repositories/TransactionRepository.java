package br.com.infogomes.analysisfinancial.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.infogomes.analysisfinancial.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	boolean existsByTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

}
