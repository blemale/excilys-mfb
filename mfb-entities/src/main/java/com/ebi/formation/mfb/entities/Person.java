package com.ebi.formation.mfb.entities;

import java.util.List;
import java.util.Set;

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
 * Classe représentant une Person (utilisateur en base, qu'il soit un client ou un admin)
 * 
 * @author excilys
 * 
 */
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false, length = 20)
	private String username;
	@Column(nullable = false)
	private String password;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "AUTHORITY", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	@Column(nullable = false)
	private Set<Role> authorities;
	@Column(length = 64)
	private String firstName;
	@Column(length = 64)
	private String lastName;
	@ManyToMany(mappedBy = "owners", cascade = CascadeType.ALL)
	private List<Compte> comptes;

	/**
	 * Retourne l'identifiant de la personne
	 * 
	 * @return l'identifiant de la personne
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the list of authorities
	 */
	public Set<Role> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities
	 *            the authorities to set
	 */
	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the comptes
	 */
	public List<Compte> getComptes() {
		return comptes;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return le username, le firstname et le lastname formaté
	 */
	public String getFullPerson() {
		return new StringBuilder(this.getUsername()).append(" - ").append(this.getFirstName()).append(" ")
				.append(this.getLastName()).toString();
	}
}