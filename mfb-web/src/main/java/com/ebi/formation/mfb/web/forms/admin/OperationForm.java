package com.ebi.formation.mfb.web.forms.admin;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.ebi.formation.mfb.entities.OperationType.Type;

/**
 * Classe représentant le formulaire de demande de création d'une opération. Nécessaire pour la validation du
 * formulaire.
 * 
 * @author fguillain
 * 
 */
public class OperationForm {

	@NotNull
	private BigDecimal montant;
	@NotNull
	private Long idCompte;
	@NotNull
	private Type type;
	@Size(max = 64)
	private String label;
	@NotNull
	@DateTimeFormat
	private DateTime dateEffet;
	@NotNull
	@DateTimeFormat
	private DateTime dateValeur;

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
	 * @return the idCompte
	 */
	public Long getIdCompte() {
		return idCompte;
	}

	/**
	 * @param idCompte
	 *            the idCompte to set
	 */
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Type type) {
		this.type = type;
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
