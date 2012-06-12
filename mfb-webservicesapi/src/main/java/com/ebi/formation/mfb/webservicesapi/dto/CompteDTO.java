package com.ebi.formation.mfb.webservicesapi.dto;

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

	public CompteDTO() {
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BigDecimal getSolde() {
		return solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

	public BigDecimal getSoldePrevisionnel() {
		return soldePrevisionnel;
	}

	public void setSoldePrevisionnel(BigDecimal soldePrevisionnel) {
		this.soldePrevisionnel = soldePrevisionnel;
	}

	public BigDecimal getEncoursCarte() {
		return encoursCarte;
	}

	public void setEncoursCarte(BigDecimal encoursCarte) {
		this.encoursCarte = encoursCarte;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
}
