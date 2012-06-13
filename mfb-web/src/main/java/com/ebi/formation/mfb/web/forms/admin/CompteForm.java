package com.ebi.formation.mfb.web.forms.admin;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Classe représentant le formulaire de demande de création d'un compte. Nécessaire pour la validation du formulaire.
 * 
 * @author fguillain
 * 
 */
public class CompteForm {

	@Size(max = 64)
	@Pattern(regexp = "\\w*")
	@NotBlank
	private String label;
	@NotNull
	private String usernameOwner;
	@NotNull
	@DecimalMin("0")
	private BigDecimal solde;

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

	/**
	 * @return the solde
	 */
	public BigDecimal getSolde() {
		return solde;
	}

	/**
	 * @return the usernameOwner
	 */
	public String getUsernameOwner() {
		return usernameOwner;
	}

	/**
	 * @param usernameOwner
	 *            the usernameOwner to set
	 */
	public void setUsernameOwner(String usernameOwner) {
		this.usernameOwner = usernameOwner;
	}

	/**
	 * @param solde
	 *            the solde to set
	 */
	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}
}
