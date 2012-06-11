package com.ebi.formation.mfb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class OperationType implements Serializable {

	private static final long serialVersionUID = -1483193605319067066L;

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
