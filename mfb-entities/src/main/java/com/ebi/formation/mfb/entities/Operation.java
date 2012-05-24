package com.ebi.formation.mfb.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;

/**
 * Classe répresentant une opération bancaire (virement, retrait, ...)
 * 
 * @author excilys
 * 
 */
/**
 * @author excilys
 * 
 */
@Entity
public class Operation {

	/**
	 * Enumération des différents types d'opérations
	 * 
	 * @author excilys
	 * 
	 */
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	@JoinColumn(name = "TYPE")
	private OperationType type;
	private BigDecimal montant;
	private DateTime dateValeur;
	private DateTime dateEffet;
	private String label;
	@OneToOne
	@JoinColumn(name = "COMPTE")
	private Compte compte;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the type
	 */
	public OperationType getType() {
		return type;
	}

	/**
	 * @return the montant
	 */
	public BigDecimal getMontant() {
		return montant;
	}

	/**
	 * @return the dateValeur
	 */
	public DateTime getDateValeur() {
		return dateValeur;
	}

	/**
	 * @return
	 */
	public DateTime getDateEffet() {
		return dateEffet;
	}

	/**
	 * @return
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return
	 */
	public Compte getCompte() {
		return compte;
	}
}
