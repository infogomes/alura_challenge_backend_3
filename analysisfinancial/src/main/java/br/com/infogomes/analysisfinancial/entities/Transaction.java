package br.com.infogomes.analysisfinancial.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_transaction")
public class Transaction implements Serializable {

	private static final long serialVersionUID = -3750967101003923979L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sourceBank;
	private String sourceAgency;
	private String sourceAccount;
	private String destinationBank;
	private String destinationAgency;
	private String destinationAccount;
	private BigDecimal value;
	private LocalDateTime time;

	public Transaction(String sourceBank, String sourceAgency, String sourceAccount, String destinationBank,
			String destinationAgency, String destinationAccount, BigDecimal value, LocalDateTime time) {
		super();
		this.sourceBank = sourceBank;
		this.sourceAgency = sourceAgency;
		this.sourceAccount = sourceAccount;
		this.destinationBank = destinationBank;
		this.destinationAgency = destinationAgency;
		this.destinationAccount = destinationAccount;
		this.value = value;
		this.time = time;
	}

	public Transaction() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getSourceBank() {
		return sourceBank;
	}

	public String getSourceAgency() {
		return sourceAgency;
	}

	public String getSourceAccount() {
		return sourceAccount;
	}

	public String getDestinationBank() {
		return destinationBank;
	}

	public String getDestinationAgency() {
		return destinationAgency;
	}

	public String getDestinationAccount() {
		return destinationAccount;
	}

	public BigDecimal getValue() {
		return value;
	}

	public LocalDateTime getTime() {
		return time;
	}

}
