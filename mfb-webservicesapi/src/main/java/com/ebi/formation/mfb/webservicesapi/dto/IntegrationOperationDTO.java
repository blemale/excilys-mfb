package com.ebi.formation.mfb.webservicesapi.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.entities.OperationType;

/**
 * DTO pour l'intégration d'{@link Operation} dans l'application.
 * 
 * @author excilys
 * 
 */
public class IntegrationOperationDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String numeroCompte;
	private OperationType.Type type;
	private BigDecimal montant;
	private DateTime dateValeur;
	private DateTime dateEffet;
	private String label;

	/**
	 * 
	 */
	public IntegrationOperationDTO() {
	}

	/**
	 * @param id
	 * @param type
	 * @param montant
	 * @param dateValeur
	 * @param dateEffet
	 * @param label
	 */
	public IntegrationOperationDTO(String numeroCompte, OperationType.Type type, BigDecimal montant,
			DateTime dateValeur, DateTime dateEffet, String label) {
		super();
		this.numeroCompte = numeroCompte;
		this.type = type;
		this.montant = montant;
		this.dateValeur = dateValeur;
		this.dateEffet = dateEffet;
		this.label = label;
	}

	/**
	 * @return the id
	 */
	public String getNumeroCompte() {
		return numeroCompte;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	/**
	 * @return the type
	 */
	public OperationType.Type getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(OperationType.Type type) {
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
