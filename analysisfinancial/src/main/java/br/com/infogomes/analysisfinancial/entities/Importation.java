package br.com.infogomes.analysisfinancial.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_importation")
public class Importation implements Serializable {

	private static final long serialVersionUID = 6580829297990880588L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dateTransaction;
	private LocalDateTime dateImportation;

	public Importation() {
		super();

	}

	public Importation(LocalDate dateTransaction, LocalDateTime dateImportation) {
		super();
		this.dateTransaction = dateTransaction;
		this.dateImportation = dateImportation;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDateTransaction() {
		return dateTransaction;
	}

	public LocalDateTime getDateImportation() {
		return dateImportation;
	}

}
