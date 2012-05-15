package com.ebi.formation.mfb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3109154373012478120L;

	public enum Right implements Serializable {
		ROLE_CLIENT, ROLE_ADMIN
	}

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "NAME")
	@Enumerated(EnumType.STRING)
	private Right right;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Right getRight() {
		return right;
	}

	public void setRight(Right right) {
		this.right = right;
	}

	@Override
	public String getAuthority() {
		return right.name();
	}
}