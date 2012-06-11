package com.ebi.formation.mfb.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 64, unique = true)
	private String label;
	@Column(nullable = false, length = 30, precision = 4)
	private BigDecimal solde;
	@Column(nullable = false)
	private BigDecimal soldePrevisionnel;
	@Column(nullable = false)
	private BigDecimal encoursCarte;
	@ManyToMany(cascade = CascadeType.ALL)
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
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * @return the soldePrevisionnel
	 */
	public BigDecimal getSoldePrevisionnel() {
		return soldePrevisionnel;
	}

	/**
	 * @param soldePrevisionnel
	 *            the soldePrevisionnel to set
	 */
	public void setSoldePrevisionnel(BigDecimal soldePrevisionnel) {
		this.soldePrevisionnel = soldePrevisionnel;
	}

	/**
	 * @return the encoursCarte
	 */
	public BigDecimal getEncoursCarte() {
		return encoursCarte;
	}

	/**
	 * @param encoursCarte
	 *            the encoursCarte to set
	 */
	public void setEncoursCarte(BigDecimal encoursCarte) {
		this.encoursCarte = encoursCarte;
	}

	/**
	 * @return the owners
	 */
	public List<Person> getOwners() {
		return owners;
	}

	/**
	 * @param owners
	 *            the owners to set
	 */
	public void setOwners(List<Person> owners) {
		this.owners = owners;
	}

	/**
	 * @return the numeroCompte
	 */
	public String getNumeroCompte() {
		return numeroCompte;
	}

	/**
	 * @param numeroCompte
	 *            the numeroCompte to set
	 */
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	/**
	 * @return le label et le solde du compte formaté
	 */
	public String getFullLabel() {
		return new StringBuilder(label).append(" / ").append(NumberFormat.getCurrencyInstance().format(solde))
				.toString();
	}

	/**
	 * @return
	 */
	public String getFullCompte() {
		return new StringBuilder(numeroCompte).append(" - ").append(label).append(" / ")
				.append(NumberFormat.getCurrencyInstance().format(solde)).toString();
	}

	/**
	 * @param person
	 */
	public void addOwner(Person person) {
		if (this.owners == null) {
			this.owners = new ArrayList<Person>();
		}
		this.owners.add(person);
	}
}
