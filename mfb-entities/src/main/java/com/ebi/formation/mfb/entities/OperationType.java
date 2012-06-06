package com.ebi.formation.mfb.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class OperationType {

	public enum Type {
		VIREMENT, CARTE, ESPECE, CHEQUE
	}

	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private Type label;

	public Long getId() {
		return id;
	}

	public Type getLabel() {
		return label;
	}
}
