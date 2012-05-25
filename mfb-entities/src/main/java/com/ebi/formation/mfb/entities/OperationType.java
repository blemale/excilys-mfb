package com.ebi.formation.mfb.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OperationType {

	public enum Type {
		// VIREMENT_ENTREE, VIREMENT_SORTIE, PAIEMENT_CARTE, RETRAIT_CARTE, DEPOT_ESPECE, RETRAIT_ESPECE,
		// PAIEMENT_CHEQUE, DEPOT_CHEQUE
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
