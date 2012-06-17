package com.ebi.formation.mfb.android;


import java.io.Serializable;
import java.math.BigDecimal;


public class CompteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String label;
	private BigDecimal solde;
	private BigDecimal soldePrevisionnel;
	private BigDecimal encoursCarte;
	private String numeroCompte;

	/**
	 * 
	 */
	public CompteDTO() {
	}

	/**
	 * @param id
	 * @param label
	 * @param solde
	 * @param soldePrevisionnel
	 * @param encoursCarte
	 * @param numeroCompte
	 */
	public CompteDTO(Long id, String label, BigDecimal solde, BigDecimal soldePrevisionnel, BigDecimal encoursCarte,
			String numeroCompte) {
		super();
		this.id = id;
		this.label = label;
		this.solde = solde;
		this.soldePrevisionnel = soldePrevisionnel;
		this.encoursCarte = encoursCarte;
		this.numeroCompte = numeroCompte;
	}

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return
	 */
	public BigDecimal getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 */
	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

	/**
	 * @return
	 */
	public BigDecimal getSoldePrevisionnel() {
		return soldePrevisionnel;
	}

	/**
	 * @param soldePrevisionnel
	 */
	public void setSoldePrevisionnel(BigDecimal soldePrevisionnel) {
		this.soldePrevisionnel = soldePrevisionnel;
	}

	/**
	 * @return
	 */
	public BigDecimal getEncoursCarte() {
		return encoursCarte;
	}

	/**
	 * @param encoursCarte
	 */
	public void setEncoursCarte(BigDecimal encoursCarte) {
		this.encoursCarte = encoursCarte;
	}

	/**
	 * @return
	 */
	public String getNumeroCompte() {
		return numeroCompte;
	}

	/**
	 * @param numeroCompte
	 */
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
}