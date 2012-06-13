package com.ebi.formation.mfb.web.forms;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Classe représentant le formulaire de demande de virement externe. Nécessaire pour la validation du formulaire.
 * 
 * @author excilys
 * 
 */
public class VirementExterneForm {

	@DecimalMin("1")
	@NotNull
	private BigDecimal montant;
	@NotNull
	private Long compteADebiter;
	@NotBlank
	private String numeroCompteACrediter;
	@Size(max = 64)
	private String motif;
	@NotNull
	@DateTimeFormat
	private DateTime dateEffet;
	@NotNull
	@DateTimeFormat
	private DateTime dateValeur;

	/**
	 * @return
	 */
	public BigDecimal getMontant() {
		return montant;
	}

	/**
	 * @return
	 */
	public String getNumeroCompteACrediter() {
		return numeroCompteACrediter;
	}

	/**
	 * @return
	 */
	public Long getCompteADebiter() {
		return compteADebiter;
	}

	/**
	 * @return
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param compteACrediter
	 */
	public void setNumeroCompteACrediter(String numeroCompteACrediter) {
		this.numeroCompteACrediter = numeroCompteACrediter;
	}

	/**
	 * @param compteADebiter
	 */
	public void setCompteADebiter(Long compteADebiter) {
		this.compteADebiter = compteADebiter;
	}

	/**
	 * @param montant
	 */
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	/**
	 * @param motif
	 */
	public void setMotif(String motif) {
		this.motif = motif;
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
}
