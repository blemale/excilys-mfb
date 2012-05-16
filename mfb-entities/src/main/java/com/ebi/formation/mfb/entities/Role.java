package com.ebi.formation.mfb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

/**
 * Classe répresentant un rôle en base (ROLE_ADMIN ou ROLE_CLIENT)
 * 
 * @author excilys
 * 
 */
@Entity
public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3109154373012478120L;

	/**
	 * Enumération des rôles
	 * 
	 * @author excilys
	 * 
	 */
	public enum Right {
		ROLE_CLIENT, ROLE_ADMIN
	}

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "NAME")
	@Enumerated(EnumType.STRING)
	private Right right;

	/**
	 * @return l'id du rôle
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Met à jour l'id du rôle
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return le droit associé à ce rôle
	 */
	public Right getRight() {
		return right;
	}

	/**
	 * Modifie le droit de ce rôle
	 * 
	 * @param right
	 */
	public void setRight(Right right) {
		this.right = right;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Override
	public String getAuthority() {
		return right.name();
	}
}
