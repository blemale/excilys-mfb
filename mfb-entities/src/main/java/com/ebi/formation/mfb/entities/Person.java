package com.ebi.formation.mfb.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Classe représentant une Person (utilisateur en base, qu'il soit un client ou un admin)
 * 
 * @author excilys
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "findUserDetailsByUsername", query = "SELECT p FROM Person p WHERE p.username = :username"),
		@NamedQuery(name = "findComptesByUsername", query = "SELECT p.comptes FROM Person p WHERE p.username = :username") })
public class Person implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1001161253306019172L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true, nullable = false, length = 20)
	private String username;
	@Column(nullable = false)
	private String password;
	@OneToMany
	@JoinTable(name = "AUTHORITY", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	@Column(nullable = false)
	private Collection<Role> authorities;
	@Column(length = 64)
	private String firstName;
	@Column(length = 64)
	private String lastName;
	@ManyToMany(mappedBy = "owners")
	private List<Compte> comptes;

	/**
	 * Retourne l'identifiant de la personne
	 * 
	 * @return l'identifiant de la personne
	 */
	public Long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return true;
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
}