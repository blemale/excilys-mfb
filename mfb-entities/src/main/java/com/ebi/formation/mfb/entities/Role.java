package com.ebi.formation.mfb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Classe répresentant un rôle en base (ROLE_ADMIN ou ROLE_CLIENT)
 * 
 * @author excilys
 * 
 */
@Entity
public class Role {

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
	@Column(name = "NAME", length = 25, nullable = false)
	@Enumerated(EnumType.STRING)
	private Right right;

	/**
	 * @return l'id du rôle
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return le droit associé à ce rôle
	 */
	public Right getRight() {
		return right;
	}
}
