package com.ebi.formation.mfb.android;

import java.io.Serializable;

public class OperationTypeDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4633877096904616908L;

	public enum Type {
		VIREMENT, CARTE, ESPECE, CHEQUE
	}
	
	private Long id;
	private Type label;
	
	public Long getId() {
		return id;
	}

	public Type getLabel() {
		return label;
	}

}
