package com.ebi.formation.mfb.web.forms.admin;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ebi.formation.mfb.entities.Person;

/**
 * Classe représentant le formulaire de demande de création d'un compte. Nécessaire pour la validation du formulaire.
 * 
 * @author fguillain
 * 
 */
public class CompteForm {

	@Size(max = 64)
	@Pattern(regexp = "\\w+")
	private String label;
	@NotNull
	private Person owner;
	@NotNull
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
	 * @return the owner
	 */
	public Person getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(Person owner) {
		this.owner = owner;
	}

	/**
	 * @return the solde
	 */
	public BigDecimal getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 *            the solde to set
	 */
	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}
}
