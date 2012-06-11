package com.ebi.formation.mfb.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Operation implements Serializable {

	private static final long serialVersionUID = 6686340799452073817L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "TYPE")
	private OperationType type;
	@Column(length = 30, precision = 4, nullable = false)
	private BigDecimal montant;
	@Column(nullable = false)
	private DateTime dateValeur;
	@Column(nullable = false)
	private DateTime dateEffet;
	@Column(length = 64, nullable = false)
	private String label;
	@OneToOne
	@JoinColumn(name = "COMPTE")
	private Compte compte;
	private Boolean operationDone;

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

	/**
	 * @return
	 */
	public Boolean getOperationDone() {
		return operationDone;
	}

	/**
	 * @param type
	 */
	public void setType(OperationType type) {
		this.type = type;
	}

	/**
	 * @param montant
	 */
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	/**
	 * @param dateValeur
	 */
	public void setDateValeur(DateTime dateValeur) {
		this.dateValeur = dateValeur;
	}

	/**
	 * @param dateEffet
	 */
	public void setDateEffet(DateTime dateEffet) {
		this.dateEffet = dateEffet;
	}

	/**
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @param compte
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/**
	 * @param operation_effectuee
	 */
	public void setOperationDone(Boolean operationDone) {
		this.operationDone = operationDone;
	}
}
