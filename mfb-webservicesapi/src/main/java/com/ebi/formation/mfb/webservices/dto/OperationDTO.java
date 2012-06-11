package com.ebi.formation.mfb.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.ebi.formation.mfb.entities.OperationType;

public class OperationDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private OperationType type;
	private BigDecimal montant;
	private DateTime dateValeur;
	private DateTime dateEffet;
	private String label;

	public OperationDTO() {
	}

	public OperationDTO(Long id, OperationType type, BigDecimal montant, DateTime dateValeur, DateTime dateEffet,
			String label) {
		super();
		this.id = id;
		this.type = type;
		this.montant = montant;
		this.dateValeur = dateValeur;
		this.dateEffet = dateEffet;
		this.label = label;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public OperationType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(OperationType type) {
		this.type = type;
	}

	/**
	 * @return the montant
	 */
	public BigDecimal getMontant() {
		return montant;
	}

	/**
	 * @param montant
	 *            the montant to set
	 */
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	/**
	 * @return the dateValeur
	 */
	public DateTime getDateValeur() {
		return dateValeur;
	}

	/**
	 * @param dateValeur
	 *            the dateValeur to set
	 */
	public void setDateValeur(DateTime dateValeur) {
		this.dateValeur = dateValeur;
	}

	/**
	 * @return the dateEffet
	 */
	public DateTime getDateEffet() {
		return dateEffet;
	}

	/**
	 * @param dateEffet
	 *            the dateEffet to set
	 */
	public void setDateEffet(DateTime dateEffet) {
		this.dateEffet = dateEffet;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}
