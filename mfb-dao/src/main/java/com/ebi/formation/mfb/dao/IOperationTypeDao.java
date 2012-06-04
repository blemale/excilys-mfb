package com.ebi.formation.mfb.dao;

import com.ebi.formation.mfb.entities.OperationType;
import com.ebi.formation.mfb.entities.OperationType.Type;

public interface IOperationTypeDao {

	OperationType getOperationTypeByType(Type type);
}
