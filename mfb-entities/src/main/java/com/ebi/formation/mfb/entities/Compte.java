package com.ebi.formation.mfb.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Classe répresentant un compte bancaire. Un compte pouvant avoir un ou plusieurs propriétaires
 * 
 * @author excilys
 * 
 */
@Entity
public class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -77570121150098921L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, length = 64, unique = true)
	private String label;
	@Column(nullable = false)
	private BigDecimal solde;
	@ManyToMany
	@JoinTable(name = "PERSON_COMPTE", joinColumns = @JoinColumn(name = "COMPTE_ID"), inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
	private List<Person> owners;
	@Column(nullable = false, unique = true)
	private String numeroCompte;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the solde
	 */
	public BigDecimal getSolde() {
		return solde;
	}

	/**
	 * @return the owners
	 */
	public List<Person> getOwners() {
		return owners;
	}

	/**
	 * @return the numeroCompte
	 */
	public String getNumeroCompte() {
		return numeroCompte;
	}

	public String getFullLabel() {
		return new StringBuilder(label).append(" / ").append(NumberFormat.getCurrencyInstance().format(solde))
				.toString();
	}
}
