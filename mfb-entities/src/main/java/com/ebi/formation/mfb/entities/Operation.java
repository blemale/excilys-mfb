package com.ebi.formation.mfb.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Classe répresentant une opération bancaire (virement, retrait, ...)
 * 
 * @author excilys
 * 
 */
@Entity
public class Operation {

	/**
	 * Enumération des différents types d'opérations
	 * 
	 * @author excilys
	 * 
	 */
	public enum OperationType {
		VIREMENT, PAIEMENT_CARTE, RETRAIT_CARTE, DEPOT_ESPECE, RETRAIT_ESPECE, PAIEMENT_CHEQUE, DEPOT_CHEQUE
	}

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "TYPE", length = 25)
	@Enumerated(EnumType.STRING)
	private OperationType type;
	private BigDecimal montant;
	@Column()
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dateValeur;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the type
	 */
	public OperationType getType() {
		return type;
	}

	/**
	 * @return the montant
	 */
	public BigDecimal getMontant() {
		return montant;
	}

	/**
	 * @return the dateValeur
	 */
	public DateTime getDateValeur() {
		return dateValeur;
	}
}
