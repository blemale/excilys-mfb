package com.ebi.formation.mfb.android;


import java.io.Serializable;
import java.math.BigDecimal;


public class OperationDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private OperationTypeDTO type;
	private BigDecimal montant;
	private String dateValeur;
	private String dateEffet;
	private String label;

	/**
	 * 
	 */
	public OperationDTO() {
	}

	/**
	 * @param id
	 * @param type
	 * @param montant
	 * @param dateValeur
	 * @param dateEffet
	 * @param label
	 */
	public OperationDTO(Long id, OperationTypeDTO type, BigDecimal montant, String dateValeur, String dateEffet,
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
	public OperationTypeDTO getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(OperationTypeDTO type) {
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
	public String getDateValeur() {
		return dateValeur;
	}

	/**
	 * @param dateValeur
	 *            the dateValeur to set
	 */
	public void setDateValeur(String dateValeur) {
		this.dateValeur = dateValeur;
	}

	/**
	 * @return the dateEffet
	 */
	public String getDateEffet() {
		return dateEffet;
	}

	/**
	 * @param dateEffet
	 *            the dateEffet to set
	 */
	public void setDateEffet(String dateEffet) {
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