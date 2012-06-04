package com.ebi.formation.mfb.web.forms;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Classe représentant le formulaire de demande de virement interne. Nécessaire pour la validation du formulaire.
 * 
 * @author excilys
 * 
 */
public class VirementInterneForm {

	@DecimalMin("10")
	@NotNull
	private BigDecimal montant;
	@NotNull
	private Long compteADebiter;
	@NotNull
	private Long compteACrediter;
	@Size(max = 64)
	private String motif;

	/**
	 * @return
	 */
	public BigDecimal getMontant() {
		return montant;
	}

	/**
	 * @return
	 */
	public Long getCompteACrediter() {
		return compteACrediter;
	}

	/**
	 * @return
	 */
	public Long getCompteADebiter() {
		return compteADebiter;
	}

	public String getMotif() {
		return motif;
	}

	/**
	 * @param compteACrediter
	 */
	public void setCompteACrediter(Long compteACrediter) {
		this.compteACrediter = compteACrediter;
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

	public void setMotif(String motif) {
		this.motif = motif;
	}
}
